package com.lsy.thread.singleton;

/**
 * 懒汉模式
 * <p>
 * 优势：减初始化压力
 * 劣势：线程不安全 不能保证唯一性
 * <p>
 *
 * @author YY
 */
public class LazySingleton {
    /**
     * 当用户调用时 进行实例化
     */
    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    /**
     * 返回实例对象
     */
    public static LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        final int maxThreads = 200;
        for (int i = 0; i < maxThreads; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + LazySingleton.getInstance());
            }).start();
        }
    }
}
