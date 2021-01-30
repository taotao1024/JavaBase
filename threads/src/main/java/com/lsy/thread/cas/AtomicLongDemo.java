package com.lsy.thread.cas;

import java.lang.management.MemoryUsage;
import java.util.concurrent.atomic.AtomicLong;

/**
 * atomic脏读
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/25
 */
public class AtomicLongDemo {
    public static void main(String[] args) throws InterruptedException {
        final MyService myService = new MyService();
        MyThread[] myThreadArrays = new MyThread[5];
        for (int i = 0; i < myThreadArrays.length; i++) {
            myThreadArrays[i] = new MyThread(myService);
        }
        for (int i = 0; i < 5; i++) {
            myThreadArrays[i].start();
        }
        Thread.sleep(1000);
        System.out.println(MyService.aiRef.get());
    }
}

class MyService {
    public static AtomicLong aiRef = new AtomicLong();

//    public void addNum() {
    synchronized public void addNum() {
        System.out.println(Thread.currentThread().getName() + "+100=" + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }
}

class MyThread extends Thread {
    MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.addNum();
    }
}
