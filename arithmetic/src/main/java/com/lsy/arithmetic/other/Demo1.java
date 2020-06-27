package com.lsy.arithmetic.other;

import java.util.Arrays;

public class Demo1 {

    public static void main(String[] args) {
        int[][] order_list = {{2, 4, 10}, {0, 3, 15}, {3, 4, 21}};
        int n = 6;
        int arr[] = new int[n];
        arr = func1(order_list, n);
        String result = Arrays.toString(arr);
        System.out.println(result);

    }

    public static int[] func1(int[][] order_list, int n) {
        // write code here
        if (order_list.length == 0 || 0 == n) {
            return null;
        }
        int temp[][] = new int[n + 1][2];
        for (int i = 0; i < order_list.length; i++) {

            for (int j = order_list[i][0]; j <= order_list[i][1]; j++) {
                temp[j][0] = j;
                temp[j][1] += order_list[i][2];
            }
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i][1];
        }
        return arr;
    }


}
