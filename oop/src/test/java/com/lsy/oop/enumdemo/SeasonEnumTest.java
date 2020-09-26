package com.lsy.oop.enumdemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonEnumTest {

    @Test
    public void testSeasonEnum() {
        for (SeasonEnum s : SeasonEnum.values()) {
            System.out.println(s);
        }
    }
}