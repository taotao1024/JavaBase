package com.lsy.thread.aqs;

import java.util.concurrent.TimeUnit;


/**
 * 可重入性：同一个锁对统一资源分配时直接分配给它
 *
 * @author YY
 */
public class MyLockDemoTest02 {
    private static int m = 0;

    private MyLock lock = new MyLock();

    public void a() {
        //加锁
        lock.lock();
        System.out.println("a被调用了");
        b();
        //释放锁
        lock.unlock();
    }

    public void b() {
        //加锁
        lock.lock();
        System.out.println("b被调用了");
        //释放锁
        lock.unlock();
    }

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
        MyLockDemoTest02 myLockDemoTest2 = new MyLockDemoTest02();
        int threads = 1;
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
//                System.out.println(myLockDemoTest.next());
                myLockDemoTest2.a();
            }).start();
        }
    }
}
