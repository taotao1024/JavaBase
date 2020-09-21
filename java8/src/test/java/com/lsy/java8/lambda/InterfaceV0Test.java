package com.lsy.java8.lambda;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.junit.Test;

public class InterfaceV0Test {
    /**
     * JDK8之前的写法
     */
    @Test
    public void getString() {
        // 匿名实现接口的抽象方法
        InterfaceV0 interfaceV0 = new InterfaceV0() {
            public void getString(String s) {
                System.out.println("我被调用了");
            }
        };
        interfaceV0.getString("");
    }

    /**
     * Lambda表达式
     */
    @Test
    public void testGetString() {
        // Lambda表达式
        InterfaceV0 test = (s) -> {
            System.out.println(s);
        };
        test.getString("函数时接口");
    }

    /**
     * Lambda表达式+行为参数化
     */
    @Test
    public void testGetStringV1() {
        // 方法引用
        InterfaceV0 test = System.out::println;
        test.getString("表达式优化");
    }

    /**
     * Lambda手动抛出异常
     */
    @Test
    public void testGetStringV2() {
        // Lambda需要手动抛出异常
        InterfaceV0 test = (x) -> {
            try {
                System.out.println(x);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        test.getString("表达式优化");
    }
}