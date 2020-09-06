package com.lsy.thread.concurrentutil;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * java.util.concurrent.CyclicBarrier
 * <p>
 * RaceDemo
 * <p>
 * 每个线程执行时，都会碰到一个屏障，直到所有线程执行结束，
 * 然后屏障便会打开，使线程继续执行下去。
 * <p>
 * CyclicBarrier内部定义了一个Lock对象，每一个线程调用await方法时，拦截的线程个数-1，
 * 然后判断剩余连接数是否为初始值Parties。如果不是，进入Lock对象的条件队列等待。
 * 如果是，执行BarrierAction对象的Runnable方法，
 * 然后将锁的条件队列中所有线程防区锁等待队列中，这些线程会以此获取锁、释放锁。
 *
 * @author YY
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(8);
        Thread[] play = new Thread[8];
        for (int i = 0; i < 8; i++) {
            play[i] = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    System.out.println(Thread.currentThread().getName() + "准备好了");
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("选手" + Thread.currentThread().getName() + "起跑");
            }, "play[" + i + "]");
            play[i].start();
        }
    }
}
