package com.lsy.arithmetic.排序;

/**
 * TODO
 *
 * @author YY
 */
public class 计数排序 {
    public static int[] countSort(int[] array) {
        int max = array[0];
        // 1、得到最大值
        for (int i = 0; i < array.length - 1; i++) {
            max = max > array[i] ? max : array[i];
        }
        System.out.println(max);

        int[] ints = new int[max + 1];

        for (int i = 0; i < array.length; i++) {
            ints[array[i]]++;
        }

        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }
}
