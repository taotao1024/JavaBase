package com.lsy.arithmetic.递归和动态规划;

import junit.framework.TestCase;

public class 最长递增子序列Test extends TestCase {
    最长递增子序列 test = new 最长递增子序列();

    public void testLis1() {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] result = test.lis1(arr);
        for (int s : result) {
            System.out.printf(s + " ");
        }
        System.out.println();
    }

    public void testLis2() {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] result = test.lis2(arr);
        for (int s : result) {
            System.out.printf(s + " ");
        }
        System.out.println();
    }
}