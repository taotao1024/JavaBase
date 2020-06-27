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
    A,
    /**
     * 测试数据
     */
    B,
    /**
     * 测试数据
     */
    C,
    /**
     * 测试数据
     */
    D;
    int init = 10;

    public void EnumDemo() {
    }

    public void m1() {
        System.out.println(init);
    }

    public static void main(String[] args) {
        A.m1();
        B.m1();
        C.m1();
        D.m1();

        System.out.println(A.getClass().getName());
    }
}
