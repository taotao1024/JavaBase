package com.lsy.oop.extendsdemo;

import org.junit.Test;

/**
 * Bird测试类
 */
public class BirdTest {

    @Test
    public void fly() {
        Ostrich ostrich = new Ostrich();
        // 因为子类Ostrich重写了父类fly()方法，所以执行子类的方法。
        ostrich.fly();
    }

    @Test
    public void testFly() {
        Bird b = new Bird();
        b.fly();
    }
}