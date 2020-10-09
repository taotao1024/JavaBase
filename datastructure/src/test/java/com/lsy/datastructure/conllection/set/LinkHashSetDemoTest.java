package com.lsy.datastructure.conllection.set;

import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.*;

public class LinkHashSetDemoTest {

    @Test
    public void testLink() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Java");
        linkedHashSet.add("Spring");
        linkedHashSet.add("SpringBoot");
        // 按照加入的顺序打印元素
        System.out.println(linkedHashSet);

        linkedHashSet.remove("Java");
        linkedHashSet.add("Java");
        System.out.println(linkedHashSet);
    }
}