package com.lsy.oop.genericity;

/**
 * 定义泛型形参的上限
 * 在极端情况下。泛型可以设置多个上限。与类同时继承父类，实现接口类似的是，
 * 为泛型形参指定多个上限时，所有接口上线必须位于类上限之后。如果需要为泛型
 * 形参指定类上限，类上限必须位于第一位。
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/05
 */
public class Apple<T extends Number & java.io.Serializable> {
    T col;

    public static void main(String[] args) {
        Apple<Integer> integerApple = new Apple<>();
        Apple<Double> doubleApple = new Apple<>();
        Apple<Long> longApple = new Apple<>();
        // 下面代码编译引发异常，String不是Number的子类
        //Apple<String> stringApple = new Apple<String>();
    }
}
