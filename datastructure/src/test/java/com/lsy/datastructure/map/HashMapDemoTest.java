package com.lsy.datastructure.map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

@RunWith(JUnit4.class)
public class HashMapDemoTest {

    private static HashMap<String, String> hashMap;

    @BeforeClass
    public static void beforeClass() {
        hashMap = new HashMap();
        hashMap.put("Java", "99");
        hashMap.put("Java8", "33");
        hashMap.put("VUE", "33");
        hashMap.put("Spring", "199");
        hashMap.put("SpringCloud", "399");
    }

    @Test
    public void testAddHashMap() {
        System.out.println(hashMap.put("Java", "1"));
        System.out.println(hashMap);
        // keySet是Map的key组成的set集合
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.containsKey("Java8"));
        System.out.println(hashMap.containsValue("33"));
        System.out.println("JDK8使用Lambda遍历结果如下 : ");
        hashMap.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
    }


    @Test
    public void testSizeAndCapactiy() throws Exception {
        HashMap<Integer, String> map = new HashMap<Integer, String>(4, 0.75f);
        map.put(1, "12");
        map.put(2, "12");
        map.put(3, "12");
        map.put(4, "12");
        // map.put("5", "12");
        //反射
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));
        //System.out.println("capacity2: " + capacity.invoke(mapType));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));


        System.out.println(map.toString());
    }

    @Test
    public void testHashMapIterator() {
        Map<String, String> map = new HashMap<String, String>(4);
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "33");
        map.put("4", "44");
        map.put("5", "55");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            if (next.getKey().equals("1") || next.getKey().equals("2")) {
                iterator.remove();
            }
           /* Map.Entry entry = iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " " + value);*/
        }
        Iterator<Map.Entry<String, String>> iteratorOut = map.entrySet().iterator();
        while (iteratorOut.hasNext()) {
            Map.Entry entry = iteratorOut.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " " + value);
        }

    }

    @Test
    public void testGetMorN() {
        System.out.println("第一组");
        System.out.println(this.GetOldM(3, 4));
        System.out.println(this.GetNewM(3, 4));
        System.out.println("第二组");
        System.out.println(this.GetOldM(6, 5));
        System.out.println(this.GetNewM(6, 5));
        System.out.println("第三组");
        System.out.println(this.GetOldM(9, 2));
        System.out.println(this.GetNewM(9, 2));
    }

    /**
     * 取余 (2^n)
     *
     * @param h
     * @param length
     * @return
     */
    int GetNewM(int h, int length) {
        return h & (length - 1);
    }

    /**
     * 取余
     *
     * @param h
     * @param length
     * @return
     */
    int GetOldM(int h, int length) {
        return h % length;
    }

    @Test
    @Ignore
    public void testSizeMaxAndCapacity() throws Exception {

        long startTime = System.currentTimeMillis();
        //模拟最大值
        HashMap<Integer, String> map = new HashMap<Integer, String>(65535);
        AtomicInteger atomic = new AtomicInteger(0);

        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                String name = Thread.currentThread().getName();
                for (int j = 0; j < 100000; j++) {
                    //int red = new Random().nextInt(10000000);
                    map.put(atomic.incrementAndGet(), "value " + name + " " + j);
                }
                latch.countDown();
            });
            threads[i].setName("Thread_:" + i);
            threads[i].start();
            threads[i].join();
        }

        long entTime = System.currentTimeMillis();

        latch.await();
        System.out.println("写入1KW条数据的执行时间 ： " + (entTime - startTime) + "毫秒");
        System.out.println("==============查询结果如下：================");

        long readStart = System.currentTimeMillis();
        System.out.println(map.get(999));
        long readend = System.currentTimeMillis();
        System.out.println("在1KW条数据中读取一条数据的时间 ： " + (readend - readStart) + "毫秒");

        //反射
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));

        //System.out.println(map.toString());
    }

    @Test
    public void testHashCapacity() {
        int i = 3;
        if (i++ < 4 * 0.75) {
            System.out.println("不用扩容");
        }
    }
}