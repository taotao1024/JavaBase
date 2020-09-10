package com.lsy.createdmeode.single.demo02;

/**
 * 懒汉模式
 *
 * @author TT
 */
public class Singleton_01 {

    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        if (null != instance) {
            return instance;
        }
        return new Singleton_01();
    }

}
