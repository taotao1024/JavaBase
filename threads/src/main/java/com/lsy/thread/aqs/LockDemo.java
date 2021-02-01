package com.lsy.thread.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock实现同步Demo
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/30
 */
public class LockDemo {
    public static void main(String[] args) {
        final MyService myService = new LockDemo().new MyService();
        MyThread[] myThreads = new MyThread[5];
        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i] = new LockDemo().new MyThread(myService);
            myThreads[i].start();
        }
    }

    class MyThread extends Thread {
        MyService myService;

        public MyThread(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.tetsMethod();
        }
    }

    class MyService {
        private Lock lock = new ReentrantLock();

        private void tetsMethod() {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + (i + 1));
                }
                System.out.println("-----------------------------------------------");
            } finally {
                lock.unlock();
            }

        }
    }
}
