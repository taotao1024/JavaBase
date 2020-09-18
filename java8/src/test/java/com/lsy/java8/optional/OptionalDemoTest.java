package com.lsy.java8.optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class OptionalDemoTest {
    OptionalDemo testOptional = new OptionalDemo();

    @Test(expected = NullPointerException.class)
    public void testNoNull() {
        testOptional.testNoNullV1(null);
    }

    @Test
    public void testHasNull() {
        testOptional.testHasNullV2(null);
    }

    @Test
    public void testHasNullV1() {
        String result = testOptional.testHasNullV1(null);
        System.out.println(result);
    }
}