package com.lsy.newjdk;

import com.lsy.newjdk.optional.TestOptional;
import org.junit.Test;

/**
 * TestOptional测试类
 */
public class TestOptionalTest {
    TestOptional testOptional = new TestOptional();

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