package com.lsy.thread.singleton;

/**
 * 饿汉模式
 * <p>
 * 优势：线程安全 唯一性
 * 劣势：占用内存、无法被GC回收、容易内存溢出
 * <p>
 *
 * @author YY
 */
public class HungerSingleton {

    private HungerSingleton() {
    }

    /**
     * Static JVM加载ClassLoader时初始化
     */
    private static HungerSingleton instance = new HungerSingleton();


    /**
     * 返回实例对象
     */
    public static HungerSingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        final int maxThreads = 20;
        for (int i = 0; i < maxThreads; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + HungerSingleton.getInstance());
            }).start();
        }
    }
}
