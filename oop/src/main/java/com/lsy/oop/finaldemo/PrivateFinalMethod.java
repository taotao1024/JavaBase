package com.lsy.oop.finaldemo;

/**
 * "重写"private final 方法
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/14
 */
public class PrivateFinalMethod {
    private final void testPrivateFinalMethod() {
    }
}

/**
 * 内部类：继承Final类
 */
class Sub extends PrivateFinalMethod {
    private final void testPrivateFinalMethod() {
    }
}
