package com.lsy.oop.abstractdemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void testCircle(){
        Circle red = new Circle("red", 10);
        System.out.println(red.calPerimeter());
        System.out.println(red.getType());
    }
}