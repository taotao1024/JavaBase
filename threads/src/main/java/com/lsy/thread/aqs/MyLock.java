package com.lsy.thread.aqs;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author YY
 */
public class MyLock implements Lock {

    private Helper helper = new Helper();

    /**
     * AQS :将子类定义为非公共内部帮助器类
     */
    private class Helper extends AbstractQueuedSynchronizer {
        /**
         * 获取锁 默认独占模式
         *
         * @param arg state
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            //0==state 可以获取锁
            if (0 == state) {
                //利用CAS修改state
                boolean isture = compareAndSetState(0, arg);
                if (isture) {
                    //设置当前线程拥有资源
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (getExclusiveOwnerThread() == Thread.currentThread()) {
                //重入锁处理
                setState(getState() + arg);
                return true;
            }
            return false;
        }

        /**
         * 释放锁 默认独占模式
         *
         * @param arg id
         * @return true||false
         */
        @Override
        protected boolean tryRelease(int arg) {
            int state = getState() - arg;
            boolean flag = false;
            //判断释放后state是否为空闲状态 state=0
            if (0 == state) {
                setExclusiveOwnerThread(null);
                setState(state);
                return true;
            }
            setState(state);
            return flag;
        }

        /**
         * 条件限制
         *
         * @return
         */
        private Condition newConditionObject() {
            return new ConditionObject();
        }
    }

    /**
     * 获取锁
     */
    @Override
    public void lock() {
        helper.acquire(1);
    }


    /**
     * 仅在调用时锁为空闲状态才获取该锁。
     *
     * @return
     */
    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    /**
     * 如果锁在给定的等待时间内空闲，并且当前线程未被中断，则获取锁。
     *
     * @param time 时间
     * @param unit 时间长度
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }


    /**
     * 如果当前线程未被中断，则获取锁。
     *
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    /**
     * 释放锁。
     */
    @Override
    public void unlock() {
        helper.release(1);
    }

    /**
     * 返回绑定到此 Lock 实例的新 Condition 实例。
     *
     * @return
     */
    @Override
    public Condition newCondition() {
        return helper.newConditionObject();
    }
}
