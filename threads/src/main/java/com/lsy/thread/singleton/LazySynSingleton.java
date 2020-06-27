package com.lsy.thread.singleton;

/**
 * 懒汉加锁模式
 * <p>
 * 优势：减初始化压力
 * 劣势：线程安全 不能保证唯一性 性能差
 * <p>
 *
 * @author YY
 */
public class LazySynSingleton {
    private static LazySynSingleton instance = null;

    private LazySynSingleton() {
    }

    /**
     * 返回实例对象
     * <p>
     * 方法锁
     * <p>
     * flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     *
     * @return 实例对象
     */
    public synchronized static LazySynSingleton getInstance() {
        if (null == instance) {
            instance = new LazySynSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        final int maxThreads = 20;
        for (int i = 0; i < maxThreads; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + LazySynSingleton.getInstance());
            }).start();
        }
    }
}
