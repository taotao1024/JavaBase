package com.lsy.oop.genericity;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 测试带下限的通配符
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/05
 */
public class TreeSetTest {
    public static void main(String[] args) {
        /**
         * String 为下限
         */
        TreeSet<String> ts1 = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object fst, Object snd) {
                // 取出对象的的类型为下限类型
                System.out.println("ts1 " + fst.getClass());
                return hashCode() > snd.hashCode() ? 1 : hashCode() < snd.hashCode() ? -1 : 0;
            }
        });
        ts1.add("hello");
        ts1.add("yuanYuan");
        ts1.add("wenWen");

        /**
         * String 为下限
         */
        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String fst, String snd) {
                // 取出对象的的类型为下限类型
                System.out.println("ts2 " + fst.getClass());
                return hashCode() > snd.hashCode() ? 1 : hashCode() < snd.hashCode() ? -1 : 0;
            }
        });
        ts2.add("hello");
        ts2.add("yuanYuan");
        ts2.add("wenWen");

        System.out.println(ts1);
        System.out.println(ts2);
    }
}
