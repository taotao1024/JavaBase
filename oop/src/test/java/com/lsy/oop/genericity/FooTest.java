package com.lsy.oop.genericity;

import org.junit.Test;

import static org.junit.Assert.*;

public class FooTest {

    @Test
    public void testFoo() {
        Foo s1 = new Foo("隐式泛型 字符串");
        Foo s2 = new <String>Foo("显示泛型 字符串");
        Foo foo = new Foo(132);
        Foo foo2 = new <Integer>Foo(123);
    }

}