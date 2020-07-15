package com.lsy.arithmetic.sort;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author YY
 */
public class 桶排序 {
    public static double[] bucketSort(double[] arr) {
        // 1、得到数列的最大值和最小值 并计算出查值d
        double max = arr[0];
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
            min = arr[i] < min ? arr[i] : min;
        }

        double d = max - min;
        // 2、初始化桶
        int bucketNum = arr.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }
        // 3、遍历原始数组，将每一个元素放入桶中
        for (int i = 0; i < arr.length; i++) {
            int num = (int) ((arr[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(arr[i]);
        }
        // 4、对每一个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            // JDK底层采用了归并排序或者归并排序的优化版本
            Collections.sort(bucketList.get(i));
        }
        // 5、输出全部元素
        double[] sortedArray = new double[arr.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }

        return sortedArray;
    }

    public static void bucketSort1(int[] arr) {
        // 计算最大值与最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        // 对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        // 将桶中的元素赋值到原序列
        int index = 0;
        for (int i = 0; i < bucketArr.size(); i++) {
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                arr[index++] = bucketArr.get(i).get(j);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
