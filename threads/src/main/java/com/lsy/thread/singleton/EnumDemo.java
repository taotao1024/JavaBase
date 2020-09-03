package com.lsy.thread.singleton;

import javax.xml.bind.SchemaOutputResolver;

/**
 * 枚举
 *
 * @author YY
 */
public enum EnumDemo {
    /**
     * 测试数据
     * 常量 在有在加载的时候才能实例化一次 方法区
     */
    TEST_A,
    /**
     * 测试数据
     */
    TEST_B,
    /**
     * 测试数据
     */
    TEST_C,
    /**
     * 测试数据
     */
    TEST_D;

    int init = 10;

    private EnumDemo() {
    }

    public void m1() {
        System.out.println(init);
    }

    public static void main(String[] args) {
        TEST_A.m1();
        TEST_B.m1();
        TEST_C.m1();
        TEST_D.m1();

        System.out.println(TEST_A.getClass().getName());
    }
}
