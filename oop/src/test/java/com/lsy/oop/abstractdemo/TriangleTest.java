package com.lsy.oop.abstractdemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testTriangle01() {
        Triangle s = new Triangle("yellow", 5, 2, 1);
        System.out.println(s.calPerimeter());
        System.out.println(s.getType());
    }

    @Test
    public void testTriangle02() {
        Triangle s = new Triangle("yellow", 5, 2, 6);
        System.out.println(s.calPerimeter());
        System.out.println(s.getType());
    } @Test
    public void testTriangle03() {
        Triangle s = new Triangle("yellow", 5, 4, 3);
        System.out.println(s.calPerimeter());
        System.out.println(s.getType());
    }
}