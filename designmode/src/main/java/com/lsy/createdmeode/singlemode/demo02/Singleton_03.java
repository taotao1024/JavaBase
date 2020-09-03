package com.lsy.createdmeode.singlemode.demo02;

/**
 * 饿汉模式
 *
 * @author TT
 */
public class Singleton_03 {

    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03() {
    }

    public static Singleton_03 getInstance() {
        return instance;
    }

}
