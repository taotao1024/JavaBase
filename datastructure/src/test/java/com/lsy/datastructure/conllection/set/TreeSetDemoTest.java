package com.lsy.datastructure.conllection.set;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class TreeSetDemoTest {

    @Test
    public void testTreeSet() {
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(-1);
        treeSet.add(-9);
        System.out.println(treeSet);

        // 输出第一个元素
        System.out.println(treeSet.first());
        // 输出最后一个元素
        System.out.println(treeSet.last());
        // 返回小于3的子集，不包含3。
        System.out.println(treeSet.headSet(3));
        // 返回大于1的子集，如果set中包含1，子集中还包含1。
        System.out.println(treeSet.tailSet(1));
        // 返回大于1，小于10的子集。
        System.out.println(treeSet.subSet(1, 10));
    }

    @Test(expected = java.lang.ClassCastException.class)
    public void testAddTreeSet() {
        class Item {
            public Item() {
                System.out.println("我被创建了");
            }
        }
        TreeSet<Object> t = new TreeSet<>();
        t.add(new Item());
        // 当添加第二个元素时，会调用该元素的compareTo方法，对象未实现Comparable接口，所以抛出ClassCastException异常
        t.add(new Item());
    }
}