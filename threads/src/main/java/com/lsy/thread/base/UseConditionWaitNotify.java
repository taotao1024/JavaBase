package com.lsy.thread.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock和Condition对象
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/02/01
 */
public class UseConditionWaitNotify {
    private ReentrantLock rLock = new ReentrantLock();
    public Condition condition = rLock.newCondition();

    public void await() {
        rLock.lock();
        try {
            System.out.println("await  时加 :" + System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
    }

    public void signal() {
        rLock.lock();
        try {
            System.out.println("signal 时加 :" + System.currentTimeMillis());
            condition.signal();
        } finally {
            rLock.unlock();
        }
    }
}
