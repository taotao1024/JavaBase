package com.lsy.arithmetic.排序;


import java.util.*;

/**
 * TODO
 *
 * @author YY
 */
public class 快速排序 {
    /**
     * 双边递归
     *
     * @param arr        数组
     * @param startIndex 头
     * @param endIndex   尾
     */
    static void quickSort0(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }
        // 基准元素
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 归并排序
        quickSort0(arr, startIndex, pivotIndex - 1);
        quickSort0(arr, pivotIndex + 1, endIndex);


    }

    /**
     * 双边循环
     *
     * @param arr        待交换数组
     * @param startIndex 开始位置下标
     * @param endIndex   结束位置下标
     * @return 基准元素下标
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            // 控制right指针比较并左移动
            while (left < right && arr[right] > pivot) {
                right--;
            }
            // 控制left指针比较并右移动
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 交换left和right指针所指向的元素
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

            }
        }
        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    /**
     * 单边递归
     *
     * @param arr        数组
     * @param startIndex 头
     * @param endIndex   尾
     */

    static void quickSort1(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        // 基准元素
        int pivotIndex = partition2(arr, startIndex, endIndex);
        // 归并排序
        quickSort1(arr, startIndex, pivotIndex - 1);
        quickSort1(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 单边循环
     *
     * @param arr        待交换数组
     * @param startIndex 开始位置下标
     * @param endIndex   结束位置下标
     * @return 基准元素下标
     */
    private static int partition2(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        //pivot和指针重合点交换
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;

        return mark;
    }

    /**
     * 单边入栈
     *
     * @param arr        数组
     * @param startIndex 头
     * @param endIndex   尾
     */

    static void quickSort2(int[] arr, int startIndex, int endIndex) {
        // 用一个集合来代替递归函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 整个数列的起止下标，以哈希的形式入栈
        HashMap<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件，栈为空
        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> pop = quickSortStack.pop();
            int pivotIndex = partition2(arr, pop.get("startIndex"), pop.get("endIndex"));

            if (pop.get("startIndex") < pivotIndex - 1) {
                HashMap<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", pop.get("startIndex"));
                leftParam.put("endIndex", pop.get("endIndex") - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < pop.get("endIndex")) {
                HashMap<String, Integer> reghtParam = new HashMap<>();
                reghtParam.put("startIndex", pivotIndex + 1);
                reghtParam.put("endIndex", pop.get("endIndex"));
                quickSortStack.push(reghtParam);
            }
        }
    }


}
