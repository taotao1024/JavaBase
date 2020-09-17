package com.lsy.java8.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class TryCatchTest {
    @Test
    public void testTryCatch() {

        try {
            int i = 1 / 0;
            int j = 2;
        } catch (ArithmeticException npe) {
            System.out.println("空指针异常");
        } finally {
            System.out.println("final必须执行");
        }

    }

    /**
     * try-with-resources 底层还是try-catch-finally
     */
    @Test
    public void testTryCatWith() {

    }
}