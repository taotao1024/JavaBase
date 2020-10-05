package com.lsy.oop.genericity;

/**
 * 泛型构造器
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/30
 */
public class Foo {
    /**
     * 泛型构造器
     *
     * @param t   泛型参数
     * @param <T> 泛型 可代表任意类型
     */
    public <T> Foo(T t) {
        System.out.println(t);
    }
}
