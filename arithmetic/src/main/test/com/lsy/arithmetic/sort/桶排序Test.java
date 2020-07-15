package com.lsy.arithmetic.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class 桶排序Test {

    @Test
    public void bucketSort() {
        double[] array = {4.12, 2.23, 3.324, 54.4, 23.5, 88.2, 16.3, 171.3};
        double[] doubles = 桶排序.bucketSort(array);
        System.out.println(Arrays.toString(doubles));
    }

    @Test
    public void bucketSort1() {
        int[] array = {1, 2, 3, 4, 5, 8, 6, 7};
        桶排序.bucketSort1(array);
    }
}