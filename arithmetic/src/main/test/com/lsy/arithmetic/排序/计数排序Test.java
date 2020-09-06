package com.lsy.arithmetic.排序;

import org.junit.Test;

import java.util.Arrays;

public class 计数排序Test {

    @Test
    public void countSort() {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        int[] result = 计数排序.countSort(arr);
        System.out.println(Arrays.toString(result));
    }
}