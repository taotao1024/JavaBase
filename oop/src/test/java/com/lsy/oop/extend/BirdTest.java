package com.lsy.oop.extend;

import org.junit.Test;

import static org.junit.Assert.*;

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