package com.lsy.thread.threadspool;

import java.util.concurrent.TimeUnit;

/**
 * 工作线程
 *
 * @author YY
 */
public class WorkThread implements Runnable {
    private String name;

    public WorkThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is started.");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
