package com.lsy.createdmeode.singlemode.demo02;

/**
 * 内部类
 *
 * @author TT
 */
public class Singleton_04 {

    private static class SingletonHolder {
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04() {
    }

    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }

}
