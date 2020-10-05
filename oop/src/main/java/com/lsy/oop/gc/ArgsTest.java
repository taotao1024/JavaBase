package com.lsy.oop.gc;

/**
 * 测试main方法入口
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/05
 */
public class ArgsTest {
    public static void main(String[] args) {
        System.out.println(args.length);
        for (String s : args) {
            System.out.println(s);
        }
    }
}
