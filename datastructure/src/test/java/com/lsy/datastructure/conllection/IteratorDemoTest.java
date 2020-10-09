package com.lsy.datastructure.conllection;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

import static org.junit.Assert.*;

public class IteratorDemoTest {

    static HashSet<String> set;

    @BeforeClass
    public static void init() {
        set = new HashSet<>();
        set.add("Java");
        set.add("XdJa");
        set.add("YonYou");
        System.out.println("set 集合中的元素个数 ： " + set.size());
    }

    @Test()
    public void iteratorTest() {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("Java")) {
                // 当通过iterator访问集合时，集合的值不会发生改变。只能通过iterator.remove()方法删除上一个访问的元素。
                iterator.remove();
            }
            // 对next进行赋值，不会修改集合本身。
            next = "修改无效";
        }
        set.forEach((s) -> System.out.println("迭代集合元素 ： " + s));
        System.out.println("set 集合中的元素个数 ： " + set.size());
    }

    @Test
    public void iteratorEach() {
        Iterator<String> iterator = set.iterator();
        iterator.forEachRemaining((s) -> System.out.println("iterator迭代集合元素 ： " + s));

        set.forEach((s) -> System.out.println("collection迭代集合元素 ： " + s));
        System.out.println("set 集合中的元素个数 ： " + set.size());
    }

    @Test(expected = java.util.ConcurrentModificationException.class)
    public void iteratorErrorTest() {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if ("Java".equals(next)) {
                // 错误示范 会引发ConcurrentModificationException异常
                // 因为迭代器采用的是快速失败机制 一旦发现集合被修改 立即引发异常
                System.out.println("删除不存在的值不会引发异常 : " + set.remove("no exist"));
                set.remove(next);
            }
            // 对next进行赋值，不会修改集合本身。
            next = "修改无效";
        }
        set.forEach((s) -> System.out.println("迭代集合元素 ： " + s));
        System.out.println("set 集合中的元素个数 ： " + set.size());
    }
}