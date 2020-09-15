package com.lsy.oop.finaldemo;

import org.junit.Test;

/**
 * CacheImmutable测试类
 */
public class CacheImmutableTest {
    @Test
    public void testCache() {
        CacheImmutable v1 = CacheImmutable.valueOf("test");
        CacheImmutable v2 = CacheImmutable.valueOf("test");
        System.out.println(v1.equals(v2));
        System.out.println(v1 == v2);
    }

}