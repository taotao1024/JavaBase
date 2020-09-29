package com.lsy.oop.gc;

import org.junit.Test;

import javax.lang.model.element.VariableElement;

import static org.junit.Assert.*;

public class StatusTranferTest {
    StatusTranfer s = new StatusTranfer();

    @Test
    public void test1() {
        s.test();
    }

    @Test
    public void test2() {
        for (int i = 0; i < 5; i++) {
            new StatusTranfer();
            //  相当于 System.gc();
            Runtime.getRuntime().gc();
        }
    }
}