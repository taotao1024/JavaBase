package com.lsy.oop.extend;

import org.junit.Test;

import static org.junit.Assert.*;

public class subTest {

    @Test
    public void testSub() {
        sub sub = new sub(1.705, 23, "张三");
        System.out.println(sub.toString());
    }

}