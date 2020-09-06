package com.lsy.oop.lambdademo;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterfaceV0Test {

    @Test
    public void testGetString() {
        // 匿名实现接口的抽象方法
        InterfaceV0 test = (s) -> {
            System.out.println(s);
        };
        test.getString("函数时接口");
    }

    @Test
    public void testGetStringV1() {
        // 匿名实现接口的抽象方法
        InterfaceV0 test = System.out::println;
        test.getString("表达式优化");
    }
}