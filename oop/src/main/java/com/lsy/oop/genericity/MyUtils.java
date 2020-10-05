package com.lsy.oop.genericity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 型变、逆变
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/05
 */
public class MyUtils {
    /**
     * @param dest 逆变 确定下限为泛型
     * @param src  泛型
     * @param <T>  返回值
     * @return
     */
    public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
        T last = null;
        for (T ele : src) {
            last = ele;
            // 逆变的泛型集合添加时安全的
            dest.add(ele);
        }
        return last;
    }

    public static void main(String[] args) {
        ArrayList<Number> ln = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        li.add(5);
        // 此处可以知道最后一个被复制的元素时Integer类型 与src集合元素的类型相同
        Integer last = copy(ln, li);
        System.out.println(ln);
    }
}
