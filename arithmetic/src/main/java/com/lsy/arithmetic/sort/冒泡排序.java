package com.lsy.arithmetic.sort;

import java.util.Arrays;

/**
 * 冒泡排序 浑沉轻浮
 *
 * @author YY
 */
public class 冒泡排序 {
    /**
     * 简单冒泡
     *
     * @param num 数组
     */
    static void sort0(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(num));
    }

    /**
     * 标志位
     *
     * @param num 数组
     */
    static void sort1(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            // 每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < num.length - 1; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    // 存在元素交换，标志位为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println(Arrays.toString(num));
    }

    /**
     * 指针
     *
     * @param num 数组
     */
    static void sort2(int[] num) {
        // 最后一次交换的位置
        int lastExchangeIndex = 0;
        int sortBorder = num.length - 1;
        for (int i = 0; i < num.length - 1; i++) {
            // 每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    // 存在元素交换，标志位为false
                    isSorted = false;
                    // 最后一次交换的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
        System.out.println(Arrays.toString(num));
    }

    /**
     * 鸡尾酒排序 双向排序
     *
     * @param num
     */
    static void sort3(int[] num) {

        for (int i = 0; i < num.length / 2; i++) {
            // 每一轮的初始值都是true
            boolean isSorted = true;
            // 奇数轮
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    // 存在元素交换，标志位为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            // 偶数轮
            for (int j = num.length - i - 1; j > i; j--) {
                if (num[j] < num[j - 1]) {
                    int temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                    // 存在元素交换，标志位为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }

        System.out.println(Arrays.toString(num));
    }
}
