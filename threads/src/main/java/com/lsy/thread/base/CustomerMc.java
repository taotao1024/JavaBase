package com.lsy.thread.base;


/**
 * 消费者
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/30
 */
public class CustomerMc {
    private String lock;

    public CustomerMc(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (!MyValue.value.equals("")) {
                    System.out.println(Thread.currentThread().getName() + "消费者 - 消费了一条数据");
                    MyValue.value = "";
                    lock.notifyAll();
                }
                lock.wait();
            }
        } catch (InterruptedException i) {
            i.printStackTrace();
        }

    }
}
