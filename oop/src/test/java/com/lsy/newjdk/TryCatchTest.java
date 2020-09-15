package com.lsy.newjdk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * TryCatch测试类
 */
@RunWith(JUnit4.class)
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