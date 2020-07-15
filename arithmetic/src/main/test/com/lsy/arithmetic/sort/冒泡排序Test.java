package com.lsy.arithmetic.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class 冒泡排序Test {
    int[] num0 = {2, 5, 1, 6, 71, 34, 32, 4};
    int[] num1 = {1, 2, 3, 4, 6, 5, 7, 8};
    int[] num2 = {1, 2, 3, 4, 8, 7, 6, 5};
    int[] num3 = {1, 2, 3, 4, 5, 8, 6, 7};

    @Before
    public void before() {
        System.out.println("==========================");
    }

    @Test
    public void sort0() {
        冒泡排序.sort0(num0);
        冒泡排序.sort0(num1);
        冒泡排序.sort0(num2);
        冒泡排序.sort0(num3);
    }

    @Test
    public void sort1() {
        冒泡排序.sort1(num0);
        冒泡排序.sort1(num1);
        冒泡排序.sort1(num2);
        冒泡排序.sort1(num3);
    }

    @Test
    public void sort2() {
        冒泡排序.sort2(num0);
        冒泡排序.sort2(num1);
        冒泡排序.sort2(num2);
        冒泡排序.sort2(num3);
    }

    @Test
    public void sort3() {
        冒泡排序.sort3(num0);
        冒泡排序.sort3(num1);
        冒泡排序.sort3(num2);
        冒泡排序.sort3(num3);
    }
}