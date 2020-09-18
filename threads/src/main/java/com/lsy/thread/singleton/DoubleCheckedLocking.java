package com.lsy.thread.singleton;

import java.net.Socket;
import java.sql.Connection;

/**
 * 双锁校验机制
 * <p>
 * 优势：减初始化压力
 * 劣势：线程安全 唯一性 性能有所提升
 * <p>
 *
 * @author YY
 */
public class DoubleCheckedLocking {
    Connection connection;
    Socket socket;

    /**
     * 私有化构造方法
     */
    private DoubleCheckedLocking() {
    }

    public static void checked() {
        //指令重排导致NPE
        Connection connection;
        Socket socket = new Socket();
        System.out.println(socket.toString());
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
        //第一次校验
        if (null == instance) {
            synchronized (DoubleCheckedLocking.class) {
                //第二次校验 冗余操作
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
                checked();
                System.out.println(Thread.currentThread().getName() + " " + instance);
            }).start();
        }
    }
}
