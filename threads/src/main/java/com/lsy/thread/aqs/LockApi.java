package com.lsy.thread.aqs;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock的常用API
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/02/01
 */
public class LockApi {
    public static void main(String[] args) {
        final Service service = new LockApi().new Service(true);
        new Thread(() -> {
            service.serviceMethod();
        }).start();
    }

    class Service {
        ReentrantLock lock;

        public Service(Boolean isFair) {
            lock = new ReentrantLock(isFair);
        }

        private void serviceMethod() {
            System.out.println("锁定情况：" + lock.getHoldCount());
            lock.lock();
            try {
                System.out.println("锁定情况：" + lock.getHoldCount());
            } finally {
                lock.unlock();
                System.out.println("锁定情况：" + lock.getHoldCount());
            }
        }
    }
}
