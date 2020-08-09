package com.lsy.arithmetic.排序;

import org.junit.Test;

import java.util.Arrays;

public class 堆排序Test {

    @Test
    public void heapSort() {
        int[] array = {1, 2, 3, 4, 5, 8, 6, 7};
        堆排序.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}