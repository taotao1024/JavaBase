package com.lsy.thread.base;

/**
 * @author yuanyuan
 * @version 1.0
 * @date 2021/02/01
 */
public class LockSpSc {
    public static void main(String[] args) throws InterruptedException {
        final UseConditionWaitNotify service = new UseConditionWaitNotify();
        final ThreadDemo threadDemo = new LockSpSc().new ThreadDemo(service);
        threadDemo.start();
        Thread.sleep(2000);
        service.signal();
    }

    class ThreadDemo extends Thread {
        private UseConditionWaitNotify useConditionWaitNotify;

        public ThreadDemo(UseConditionWaitNotify useConditionWaitNotify) {
            this.useConditionWaitNotify = useConditionWaitNotify;
        }

        @Override
        public void run() {
            useConditionWaitNotify.await();
        }
    }
}
