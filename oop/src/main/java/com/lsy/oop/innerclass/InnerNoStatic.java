package com.lsy.oop.innerclass;

/**
 * 非静态内部类无法拥有静态变量、静态方法、静态代码块
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/21
 */
public class InnerNoStatic {
    /**
     * 非静态内部类属于寄生于外部类对象中
     */
    private class InnerClass {
        // 非静态内部类无法拥有静态代码块
        // static { System.out.println("编译失败"); }

        // 非静态内部类无法拥有静态变量
        // private static int inProp;

        // 非静态内部类无法拥有静态方法
        // private static void test(){};

    }
}
