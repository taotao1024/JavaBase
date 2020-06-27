package com.lsy.thread.volatiledemo;

import java.util.concurrent.TimeUnit;

/**
 * @author Lsy
 */
public class ReaderAndUpdater {
    private final static int MAX = 5;
    /**
     * 没有Volatile VS 有Volatile<p>
     * update 1------ update 1<p>
     * read 1-------- read 1<p>
     * update 2------update 2<p>
     * update 3------read 2<p>
     * update 4------update 3<p>
     * update 5------read 3<p>
     * 死循环--------update 4<p>
     * --------------read 4<p>
     * --------------update 5<p>
     * --------------read 5<p>
     * --------------结束线程<p>
     */
    private volatile static int init_value = 0;

    /**
     * lambda表达式 AJCG不推荐使用
     * <p/>
     * 解决缓存一致性：<p>
     * 1、总线枷锁(锁粒度太大)<p>
     * 2、MESI、MSI协议(当共享变量在Cache被更新后，通知其他线程将变Cache line置为无效状态
     * ，其他线程访问这个变量时，只能从总内存去获取)
     * <p>
     * 工作空间存放的是引用类型的地址，引用类型的值存放在工作空间中，修改数据是在CPU的寄存器中。
     *
     * @param args String
     */
    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (localValue != init_value) {
                    System.out.println("read " + init_value);
                    localValue = init_value;
                }
            }
        }, "Reader").start();

        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (localValue < MAX) {
                    System.out.println("update " + ++localValue);
                    init_value = localValue;
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Update").start();
    }
}
