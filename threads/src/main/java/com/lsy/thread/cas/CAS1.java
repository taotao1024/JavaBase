package com.lsy.thread.cas;

import sun.misc.Unsafe;
import sun.misc.VM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author YY
 */
public class CAS1 {
    /**
     * 常量 int
     */
    private static volatile int m = 0;
    /**
     * 原子 Int
     */
    private static AtomicInteger atomic = new AtomicInteger(0);


    private static void increase() {
        /*
         iconst_1
         iadd
         putstatic
        */
        m++;
    }

    private static void increaseAtomic() {

        // setup to use Unsafe.compareAndSwapInt for updates
        /*private static final Unsafe unsafe = Unsafe.getUnsafe();
        private static final long valueOffset;

        static {
            try {
                valueOffset = unsafe.objectFieldOffset
                        (AtomicInteger.class.getDeclaredField("value"));
            } catch (Exception ex) { throw new Error(ex); }
        }

        private volatile int value;*/

        /*
        class 文件
        109: invokevirtual #13
        // Method java/util/concurrent/atomic/AtomicInteger.get:()I
         */

        //incrementAndGet() --> unsafe --> unsafe.cpp --> 汇编 cmpxchg --> 硬件支持
        atomic.incrementAndGet();
//        Atomically increments by one the current value.
        /*public final int incrementAndGet() {
            return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
        }*/

//        CAS                           要修改的值           期望值   新值
//        public final int getAndAddInt(java.lang.Object o, long l, int i)
//        CAS          本地方法 --> 本地方法栈 --> CPU执行
//        public final native boolean compareAndSwapInt(java.lang.Object o, long l, int i, int i1);

//        public static sun.misc.Unsafe getUnsafe() { /* compiled code */ }
//        通过JVM调用底层指令
//        if(!VM.isSystemDomainLoader(var0.getClassLoader))

//        汇编指令
//        LOCK_IF_MP(mp);
//        cmpxchg dword ptr [edx],ecx
    }

    /**
     * join 控制线程执行顺序
     *
     * @param args String[]
     * @throws InterruptedException 中断异常
     */
    public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[20];
        for (int i = 0; i < 20; i++) {
            t[i] = new Thread(() -> {
                CAS1.increase();
            });
            t[i].start();
            t[i].join();
        }
        System.out.println(m);

        Thread[] tf = new Thread[20];
        for (int i = 0; i < 20; i++) {
            tf[i] = new Thread(() -> {
                CAS1.increaseAtomic();
            });
            tf[i].start();
            tf[i].join();
        }
        System.out.println(atomic.get());
    }
}
