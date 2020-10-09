package com.lsy.datastructure.conllection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * 通过Collection操作集合
 */
@RunWith(JUnit4.class)
public class CollectionDemoTest {

    static Collection<Object> collection;

    @BeforeClass
    public static void init() {
        collection = new ArrayList<>();
        collection.add("Java");
        collection.add("VUE");
        collection.add("XdJa");
        collection.add("YonYou");
        System.out.println("初始化set 集合中的元素个数 ： " + collection.size());
    }

    @Test
    public void collectionTest() {
        // 集合里不能存放基本数据类型，但是Java支持自动装箱
        collection.add(6);
        System.out.println("collection 集合中的元素个数 ： " + collection.size());

        // 删除指定元素
        collection.remove(6);
        System.out.println("collection 集合中的元素个数 ： " + collection.size());

        System.out.println("collection集合中是否包含元素 6 ：" + collection.contains(6));
        System.out.println("collection集合中是否包含元素 孙悟空 ：" + collection.contains("孙悟空"));
        // 判断是否包含指定元素 大小写敏感
        System.out.println("collection集合中是否包含元素 java ：" + collection.contains("java"));
        System.out.println("collection集合中是否包含元素 Java ：" + collection.contains("Java"));
        System.out.println("collection集合中的元素 ：" + collection.toString());

        HashSet<String> set = new HashSet<>();
        collection.add("用友");
        collection.add("信大捷安");
        set.add("用友");
        set.add("信大捷安");
        System.out.println("collection集合中的元素 ：" + collection.toString());
        System.out.println("collection 集合中的元素个数 ： " + collection.size());
        System.out.println("set ：" + set.toString());
        System.out.println("set 集合中的元素个数 ： " + set.size());
        System.out.println("collection集合中是否包含集合 set ：" + collection.containsAll(set));

        // 用collection集合删除set集合里的元素
        collection.removeAll(set);
        System.out.println("collection 集合中的元素个数 ： " + collection.size());

        // 删除collection集合中的所有元素
        collection.clear();
        System.out.println("collection 集合中的元素个数 ： " + collection.size());

        // 控制set集合中只剩下collection集合里也包含的元素
        set.retainAll(collection);
        System.out.println("set 集合中的元素个数 ： " + set.size());
    }

    @Test
    public void collectionEach() {
        collection.forEach((s) -> System.out.println("迭代集合元素 ： " + s));
    }

    @Test
    public void collectionRemoveIf() {
        // 删除符合filter条件的元素
        collection.removeIf((s) -> ((String) s).length() == 4);
        collection.forEach((s) -> System.out.println("迭代集合元素 ： " + s));
    }
}