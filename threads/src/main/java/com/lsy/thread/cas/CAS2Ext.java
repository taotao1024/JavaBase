package com.lsy.thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 弊端：ABA 问题
 * 改进：版本号 时间戳机制 AtomicStampedReference<V>
 *
 * @author YY
 */
public class CAS2Ext {
    /**
     * 常量 int
     */
    private static volatile int m = 0;
    /**
     * 原子 Int
     */
    private static AtomicInteger atomic = new AtomicInteger(100);
    /**
     * 时间戳机制 initialRef初始值为100 stamp版本为1
     */
    private static AtomicStampedReference asr = new AtomicStampedReference(100, 1);


    /**
     * 原子操作
     */
    private static void increaseAtomic() {
        atomic.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(" AtomicStampedReference<V> 改进 ");

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = asr.compareAndSet(100, 110, asr.getStamp(), asr.getStamp() + 1);
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " " + result);

            boolean result2 = asr.compareAndSet(110, 100, asr.getStamp(), asr.getStamp() + 1);
            System.out.println(threadName + " " + result2);
        }).start();

        new Thread(() -> {
            int stamp = asr.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = asr.compareAndSet(100, 120, stamp, stamp + 1);
            //boolean result = asr.compareAndSet(100, 120, asr.getStamp(), stamp + 1);
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " " + result);
        }).start();
    }
}
