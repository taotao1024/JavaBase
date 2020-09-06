package com.lsy.oop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/13
 */
@RunWith(JUnit4.class)
public class TryCatch {
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
