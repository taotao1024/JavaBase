package com.lsy.oop.extend;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseClassTest {
    @Test
    public void testSuper() {
        SubClass subClass = new SubClass();
        subClass.accessOwner();
        subClass.accessSuper();
    }
}