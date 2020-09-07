package com.lsy.oop.extend;

import org.junit.Test;

import static org.junit.Assert.*;

public class FruitTest {

    @Test
    public void info() {
        Apple apple = new Apple();
        // apple本身没有weight属性和info()方法，因为继承父类Fruit，所以可以访问。
        apple.weight = 10;
        apple.info();
    }
}