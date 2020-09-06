package com.lsy.thread.aqs;

import java.util.concurrent.TimeUnit;

/**
 * @author YY
 */
public class Demo01 {
    private static int m = 0;

    int next() {
        try {
            TimeUnit.SECONDS.sleep(2);
            return m++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        Demo01 myLockDemo = new Demo01();
        int threads = 20;
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                System.out.println(myLockDemo.next());
            }).start();
        }
    }
}
