package com.lsy.datastructure.hashmap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/5
 */
@RunWith(JUnit4.class)
public class HashMapSize {
    @Test
    public void getSize() throws Exception {
        Map<String, String> map = new HashMap<String, String>(4);
        map.put("1", "12");
        map.put("2", "12");
        map.put("3", "12");
        map.put("4", "12");
        map.put("5", "12");
        map.put("6", "12");
        map.put("7", "12");
        map.put("8", "12");
        map.put("9", "12");
        map.put("10", "12");
        //反射
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));


        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));
    }

    @Test
    public void testGetM() {
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
}
