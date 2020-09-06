package com.lsy.thread.threadspool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 线程任务
 *
 * @author YY
 */
public class TaskDemo implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is running");
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
