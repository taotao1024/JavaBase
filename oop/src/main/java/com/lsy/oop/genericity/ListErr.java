package com.lsy.oop.genericity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * list联联系
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/29
 */
public class ListErr {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java开发", "Vue开发", "Linux驱动开发");
        strings.forEach(list -> System.out.println(list.toString()));

        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        // 枚举不会生成额外的class文件 且无法被重写
        System.out.println(strings1.getClass() == integers.getClass());
    }
}
