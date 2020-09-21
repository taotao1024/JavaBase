package com.lsy.java8.lambda;

/**
 * 函数式接口，只能有一个抽象方法。
 * <p>
 * 一言以蔽之，函数式接口就是只定义一个抽象方法的接口
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/17
 */
@FunctionalInterface
public interface InterfaceV1 {
    /**
     * 测试
     *
     * @param s String：函数描述符
     */
    void printUtils(String s);

}
