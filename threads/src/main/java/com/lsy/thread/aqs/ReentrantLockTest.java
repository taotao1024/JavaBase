package com.lsy.thread.aqs;


import java.util.concurrent.locks.ReentrantLock;


/**
 * 可重入性：同一个锁对统一资源分配时直接分配给它
 *
 * @author YY
 */
public class ReentrantLockTest {
    private static int m = 0;

    private ReentrantLock lock = new ReentrantLock();

    public void a() {
        //加锁
        lock.lock();
        try {
            System.out.println("a被调用了");
            b();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public void b() {
        //加锁
        lock.lock();
        try {
            System.out.println("b被调用了");
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest myLockDemoTest2 = new ReentrantLockTest();
        int threads = 1;
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                myLockDemoTest2.a();
            }).start();
        }
    }
}
