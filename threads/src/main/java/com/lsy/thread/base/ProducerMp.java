package com.lsy.thread.base;

/**
 * 生产者
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/30
 */
public class ProducerMp {
    private String lock;

    public ProducerMp(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!MyValue.value.equals("")) {
                    // 有数据则阻塞
                    lock.wait();
                } else {
                    // 没有数据则生产一条
                    System.out.println(Thread.currentThread().getName()+"生产者 - 生产了一条数据");
                    MyValue.value = System.currentTimeMillis() + "_" + System.nanoTime();
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException i) {
            i.printStackTrace();
        }

    }
}
