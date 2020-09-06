package com.lsy.thread.concurrentutil;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * java.util.concurrent.Semaphore 信号量
 * <p>
 * CarDemo
 * <p>
 * 资源有限共享：例如停车场问题
 * <p>
 * 信号量表示可以使用的资源数量
 * 1、请求资源 acquire()  从此信号量获取一个许可，在提供一
 * 个许可前一直将线程阻塞，否则线程被中断。<p>
 * 2、使用资源<p>
 * 3、释放资源 release() 释放一个许可，将其返回给信号量。<p>
 *
 * @author YY
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //创建Semaphore 声明5个停车位
        Semaphore sp = new Semaphore(5);

        Thread[] car = new Thread[10];
        for (int i = 0; i < 10; i++) {
            car[i] = new Thread(() -> {
                try {
                    //请求许可
                    TimeUnit.SECONDS.sleep(1);
                    sp.acquire();
                    System.out.println(Thread.currentThread().getName() + " 可以进停车场");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //使用资源
                try {
                    int randomNub = new Random().nextInt(10);
                    TimeUnit.SECONDS.sleep(randomNub);
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " 停留了" + randomNub + "秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //离开（释放资源）
                try {
                    TimeUnit.SECONDS.sleep(2);
                    sp.release();
                    System.out.println(Thread.currentThread().getName() + " 离开停车场");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "car[" + i + "]");
            car[i].start();
        }


    }

}
