package com.lsy.thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 弊端：ABA 问题
 * 改进：版本号 时间戳机制 AtomicStampedReference<V>
 *
 * @author YY
 */
public class CAS2 {
    /**
     * 常量 int
     */
    private static volatile int m = 0;
    /**
     * 原子 Int
     */
    private static AtomicInteger atomic = new AtomicInteger(100);

    /**
     * 原子操作
     */
    private static void increaseAtomic() {
        atomic.incrementAndGet();
    }

    public static void main(String[] args) {
        new Thread(() -> {
            boolean result = atomic.compareAndSet(100, 110);
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " " + result + " " + atomic.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomic.compareAndSet(110, 100);
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " " + result + " " + atomic.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomic.compareAndSet(100, 120);
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " " + result + " " + atomic.get());
        }).start();
    }
}
