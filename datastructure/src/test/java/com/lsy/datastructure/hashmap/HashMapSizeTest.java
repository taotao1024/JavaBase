package com.lsy.datastructure.hashmap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class HashMapSizeTest {

    @Test
    public void getSize() {
        System.out.println("1");
    }

    @Test
    public void testIterator() {
    }

    @Test
    public void testGetM() {
    }

    @Test
    public void getNewM() {
    }

    @Test
    public void getOldM() {
    }

    @Test
    public void getSizeMax() {
    }

    @Test
    public void testHash() {
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
        map.put("1", "12");
        map.put("2", "12");
        map.put("3", "12");
        map.put("4", "12");
        map.put("5", "12");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
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