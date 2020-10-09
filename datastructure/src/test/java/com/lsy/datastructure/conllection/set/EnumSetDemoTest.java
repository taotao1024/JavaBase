package com.lsy.datastructure.conllection.set;

import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.*;

public class EnumSetDemoTest {

    enum Season {
        ONE, TWO, THREE, OTHER
    }

    @Test
    public void testCreateEnum() {
        EnumSet<Season> s1 = EnumSet.allOf(Season.class);
        System.out.println(s1);

        EnumSet<Season> s2 = EnumSet.noneOf(Season.class);
        System.out.println(s2);

        s2.add(Season.ONE);
        s2.add(Season.THREE);
        s2.add(Season.TWO);
        // set不可重复
        s2.add(Season.ONE);
        System.out.println(s2);
    }
}