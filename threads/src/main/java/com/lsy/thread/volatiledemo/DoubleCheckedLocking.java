package com.lsy.thread.volatiledemo;


/**
 * @author YY
 */
public class DoubleCheckedLocking {
    /**
     * 私有化构造函数
     */
    private DoubleCheckedLocking() {

    }

    /**
     * Volatile:可见性、有序性
     * <p>
     * lock:instance 汇编指令
     */
    private volatile static DoubleCheckedLocking instance;

    /**
     * DCL：原子性、可见性、有序性
     * <p>类锁
     * monitorenter monitorexit(正常出口) monitorexit(异常出口) JVM指令
     *
     * @return
     */
    public static DoubleCheckedLocking getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckedLocking.class) {
                if (null == instance) {
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        final int maxThreads = 10;
        for (int i = 0; i < maxThreads; i++) {
            new Thread(() -> {
                DoubleCheckedLocking instance = DoubleCheckedLocking.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + instance);
            }).start();
        }
    }
}
