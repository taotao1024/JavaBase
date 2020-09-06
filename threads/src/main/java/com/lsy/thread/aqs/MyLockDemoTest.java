package com.lsy.thread.aqs;

import java.util.concurrent.TimeUnit;


/**
 * @author YY
 */
public class MyLockDemoTest {
    private static int m = 0;

    private MyLock lock = new MyLock();

    int next() {
        try {
            //加锁
            lock.lock();
            TimeUnit.SECONDS.sleep(2);
            return m++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyLockDemoTest myLockDemoTest = new MyLockDemoTest();
        int threads = 20;
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                System.out.println(myLockDemoTest.next());
            }).start();
        }
    }
}
