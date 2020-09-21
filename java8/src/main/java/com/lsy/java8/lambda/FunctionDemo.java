package com.lsy.java8.lambda;

import java.util.function.Function;

/**
 * 复合函数
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/20
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> j = f.compose(g);
        int result = h.apply(2);
        int result2=j.apply(2);
        System.out.println(result);
        System.out.println(result2);
    }
}
