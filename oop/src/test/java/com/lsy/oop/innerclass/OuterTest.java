package com.lsy.oop.innerclass;

import org.junit.Test;

import static org.junit.Assert.*;

public class OuterTest {

    @Test
    public void accessInnerProp() {
        new Outer().accessInnerProp();
        new Outer().new Inner().accessOuterProp();
    }
}