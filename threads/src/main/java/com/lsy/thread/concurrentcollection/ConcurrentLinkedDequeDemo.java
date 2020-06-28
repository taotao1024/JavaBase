package com.lsy.thread.concurrentcollection;

import java.util.concurrent.ConcurrentLinkedDeque;


/**
 * 非阻塞式集合
 * @author YY
 */
public class ConcurrentLinkedDequeDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedDeque<String> cld = new ConcurrentLinkedDeque();
        int threadMax = 20;
        int maxDate = 1000;
        Thread[] threadsAdd = new Thread[threadMax];
        //添加数据
        for (int i = 0; i < threadMax; i++) {
            threadsAdd[i] = new Thread(() -> {
                for (int j = 0; j < maxDate; j++) {
                    cld.add(Thread.currentThread().getName() + " :Element" + j);
                }
            });
            threadsAdd[i].start();
            threadsAdd[i].join();
        }
        System.out.println("after add  size:" + cld.size());

        Thread[] threadsPoll = new Thread[threadMax];
        //删除数据
        for (int i = 0; i < threadMax; i++) {
            threadsPoll[i] = new Thread(() -> {
                for (int j = 0; j < maxDate / 2; j++) {
                    cld.pollFirst();
                    cld.pollLast();
                }
            });
            threadsPoll[i].start();
            threadsPoll[i].join();
        }
        System.out.println("after poll size:" + cld.size());
    }
}
