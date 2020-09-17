package com.lsy.java8.optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class OptionalDemoTest {
    OptionalDemo testOptional = new OptionalDemo();

    @Test(expected = NullPointerException.class)
    public void testNoNull() {
        testOptional.testNoNull(null);
    }

    @Test
    public void testHasNull() {
        testOptional.testHasNull(null);
    }

    @Test
    public void testHasNullV1() {
        String result = testOptional.testHasNullV1(null);
        System.out.println(result);
    }
}