package com.lsy.thread.concurrentcollection;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞式集合
 *
 * @author YY
 */
public class LinkedBlockingDequeDemo {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> lbd = new LinkedBlockingDeque(5);
        int maxDate = 1000;
        String name = Thread.currentThread().getName();
        //添加数据
        Thread threadAdd = new Thread(() -> {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 3; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        lbd.add(name + " :Element" + i + "");
                        System.out.println("after  add size:" + lbd.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadAdd.setName("threadAdd");
        threadAdd.start();

        //删除数据
        Thread threadPoll = new Thread(() -> {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 3; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        lbd.takeFirst();
                        System.out.println("threadPool size:" + lbd.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("thread end size:" + lbd.size());
        });
        threadAdd.setName("threadPool");
        threadPoll.start();
    }
}
