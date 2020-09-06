package com.lsy.lock.zklock2;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description: zkTest
 * @Author: 敖丙
 * @date: 2020-04-06
 **/
public class ZkTest implements Runnable, Lock {
    static int inventory = 10;
    private static final int NUM = 10;
    private static CountDownLatch cdl = new CountDownLatch(1);

    private static final String IP_PORT = "120.79.134.119:2181";
    private static final String Z_NODE = "/zkLock";

    private static ZkClient zkClient = new ZkClient(IP_PORT);


    public static void main(String[] args) {
        try {

            for (int i = 1; i <= NUM; i++) {
                new Thread(new ZkTest()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            new ZkTest().lock();
            if (inventory > 0) {
                inventory--;
            }
            System.out.println(inventory);
            return;
        } finally {
            new ZkTest().unlock();
            System.out.println("释放锁");
        }
    }

    @Override
    public void lock() {
        // 尝试加锁
        if (tryLock()) {
            return;
        }
        // 进入等待 监听
        waitForLock();
        // 再次尝试
        lock();
    }

    @Override
    public boolean tryLock() {
        try {
            zkClient.createPersistent(Z_NODE);
            return true;
        } catch (ZkNodeExistsException e) {
            return false;
        }
    }

    @Override
    public void unlock() {
        zkClient.delete(Z_NODE);
    }

    public void waitForLock() {
        System.out.println("加锁失败");
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("唤醒");
                cdl.countDown();
            }
        };
        // 监听
        zkClient.subscribeDataChanges(Z_NODE, listener);
        if (zkClient.exists(Z_NODE)) {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放监听
        zkClient.unsubscribeDataChanges(Z_NODE, listener);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}