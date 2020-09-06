package com.lsy.arithmetic.递归和动态规划;

/**
 * 举例: arr={2,1,5,3,6,4,8,9,7} 返回{1,3,4,8,9}、{1,5,6,8,9}
 *
 * @author 19134
 */
public class 最长递增子序列 {
    /**
     * 递归解法 时间复杂度为O(N²)
     *
     * @param arr 数组
     * @return 最长递增子序列
     */
    public int[] lis1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }

    /**
     * 递归解法 时间复杂度为O(N*logN)
     *
     * @param arr 数组
     * @return 最长递增子序列
     */
    public int[] lis2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        int[] dp = getdp2(arr);
        return generateLIS(arr, dp);
    }

    /**
     * O(N²)
     *
     * @param arr
     * @return
     */
    private int[] getdp1(int[] arr) {
        //长度为N的数字DP dp[i]表示在arr[i]这个结尾的情况下，arr[0~i]中最大的递增子序列。
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // dp={1,1,2,2,3,3,4,5,4}
        return dp;
    }

    /**
     * O(N*logN)
     * 二分查找
     *
     * @param arr
     * @return
     */
    private int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = 1 + l;
        }
        // dp={1,1,2,2,3,3,4,5,4}
        return dp;
    }

    private int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        // 获得dp中的最大值和对应的数组下标
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        // 结果数组
        int[] lis = new int[len];
        // 结尾的数字是9
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }
}
