package com.lsy.createdmeode.singlemode.demo02;

/**
 * 安全懒汉
 *
 * @author TT
 */
public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance() {
        if (null != instance) {
            return instance;
        }
        return new Singleton_02();
    }

}
