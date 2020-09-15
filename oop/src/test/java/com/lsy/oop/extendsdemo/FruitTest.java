package com.lsy.oop.extendsdemo;

import org.junit.Test;

/**
 * Fruit测试类
 */
public class FruitTest {

    @Test
    public void info() {
        Apple apple = new Apple();
        // apple本身没有weight属性和info()方法，因为继承父类Fruit，所以可以访问。
        apple.weight = 10;
        apple.info();
    }
}