package com.lsy.oop.extendsdemo;

import org.junit.Test;

/**
 * Base测试类
 */
public class BaseTest {

    @Test
    public void testSub() {
        Sub sub = new Sub(1.705, 23, "张三");
        System.out.println(sub.toString());
    }

}