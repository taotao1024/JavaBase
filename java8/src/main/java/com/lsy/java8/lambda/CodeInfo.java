package com.lsy.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Filter;

/**
 * 方法引用
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/20
 */
public class CodeInfo {
    public CodeInfo() {
        System.out.println("我被调用了");
    }

    public static void main(String[] args) {

        Runnable aNew = CodeInfo::new;
        aNew.run();

        Supplier<FilterApple.Apple> c1 = FilterApple.Apple::new;
        FilterApple.Apple apple = c1.get();

        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);
    }
}
