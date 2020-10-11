package com.lsy.datastructure.conllection.list;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class ArrayListDemoTest {


    static ArrayList<Object> array;

    @BeforeClass
    public static void init() {
        array = new ArrayList<>();
        array.add("Java");
        array.add("VUE");
        array.add("XdJa");
        array.add("YonYou");
        System.out.println("初始化array集合中的元素个数 ： " + array.size());
    }

    @Test
    public void testAddMethod() {
        array.add(0, "头插");
        array.add(array.size(), "尾插");
        System.out.println(array);
        // arrayList能匹配到新建的元素
        System.out.println(array.indexOf(new String("Java")));
        System.out.println(array.indexOf(new String("java")));
    }

    @Test
    public void testEqualsMethod() {
        class A {
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        }
        array.remove(new A());
        System.out.println(array);

        array.remove(new A());
        System.out.println(array);

    }

    @Test
    public void testSortMethod() {
        array.sort((s1, s2) -> ((String) s1).length() - ((String) s2).length());
        System.out.println(array);
        array.replaceAll((s) -> ((String) s).length());
        System.out.println(array);
    }

    @Test
    public void testListIterator() {
        System.out.println("正向迭代");
        final ListIterator<Object> listIterator = array.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("正向迭代 : " + listIterator.next());
        }

        System.out.println("反向迭代");
        while (listIterator.hasPrevious()) {
            System.out.println("正向迭代 : " + listIterator.previous());
        }
    }
}