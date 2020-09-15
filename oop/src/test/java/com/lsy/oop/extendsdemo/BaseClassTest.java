package com.lsy.oop.extendsdemo;

import org.junit.Test;

/**
 * BaseClass测试类
 */
public class BaseClassTest {
    @Test
    public void testSuper() {
        SubClass subClass = new SubClass();
        subClass.accessOwner();
        subClass.accessSuper();
    }
}