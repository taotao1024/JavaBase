package com.lsy.thread.base;


/**
 * 消费者
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/30
 */
public class CustomerSc {
    private String lock;

    public CustomerSc(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (!MyValue.value.equals("")) {
                    System.out.println("消费者 - 消费了一条数据");
                    MyValue.value = "";
                    lock.notify();
                }
                lock.wait();
            }
        } catch (InterruptedException i) {
            i.printStackTrace();
        }

    }
}
