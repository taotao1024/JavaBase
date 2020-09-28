package com.lsy.oop.enumdemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperationTest {

    @Test
    public void testOperation() {
        System.out.println(Operation.PLUS.eval(1, 2));
        System.out.println(Operation.MINUS.eval(1, 2));
        System.out.println(Operation.TIMES.eval(1, 2));
        System.out.println(Operation.DIVIDE.eval(1, 2));
    }
}