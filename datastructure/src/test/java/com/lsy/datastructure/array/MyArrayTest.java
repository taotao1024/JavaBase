package com.lsy.datastructure.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MyArrayTest {
    /**
     * 数组长度
     */
    private int[] array;
    /**
     * 数组实际大小
     */
    private int size;

    @Test
    public void testArrayRead() {
        this.array = new int[]{1, 2, 13, 24, 12, 34, 12, 3, 41, 234};
        assertEquals(array.length, array.length);

        assertEquals(array[3], 24);
    }

    @Test
    public void testArrayUpdata() {
        this.array = new int[]{1, 2, 13, 24, 12, 34, 12, 3, 41, 234};
        assertEquals(array[3], 24);
        this.array[3] = 12;
        assertEquals(array[3], 12);
    }

}