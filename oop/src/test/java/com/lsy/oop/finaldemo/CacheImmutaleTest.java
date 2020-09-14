package com.lsy.oop.finaldemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CacheImmutaleTest {
    @Test
    public void testCache(){
        CacheImmutale v1 =  CacheImmutale.valueOf("test");
        CacheImmutale v2 =  CacheImmutale.valueOf("test");
        System.out.println(v1.equals(v2));
        System.out.println(v1==v2);
    }

}