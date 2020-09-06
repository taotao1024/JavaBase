package com.lsy.thread.distributedlock;

import java.util.concurrent.locks.Lock;

/**
 * @author YY
 */
public class Main {

    public static void main(String[] args) {
        // 模拟两个人下单
        Thread thread1 = new Thread(new UserThread(), "user1");
        Thread thread2 = new Thread(new UserThread(), "user2");

        thread1.start();
        thread2.start();
    }

    // public static Lock lock = new ReentrantLock();

    public static Lock lock = new ZkLock();

    static class UserThread implements Runnable {
        @Override
        public void run() {
            // 创建订单
            new Order().createOrder();
            // 获取锁资源
            lock.lock();
            try {
                // 减库存
                Boolean result = new Stock().reduceStock();
                if (result) {
                    System.out.println(Thread.currentThread().getName() + " 减库存成功");
                    // 支付
                    new Pay().pay();
                } else {
                    System.out.println(Thread.currentThread().getName() + " 减库存失败");
                }
            } finally {
                // 释放锁资源
                lock.unlock();
            }


        }
    }
}
