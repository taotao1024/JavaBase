package com.lsy.thread.base;

import lombok.SneakyThrows;

/**
 * 多生产者多消费者（MPMC）：操作值
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/30
 */
public class ValueMpMc {
    public static void main(String[] args) {
        final String lock = new String();
        final ProducerMp producerMp = new ProducerMp(lock);
        final CustomerMc customerMc = new CustomerMc(lock);
        final ThreadMp[] threadMps = new ThreadMp[2];
        final ThreadMc[] threadMcs = new ThreadMc[2];

        for (int i = 0; i < 2; i++) {
            threadMps[i] = new ThreadMp(producerMp);
            threadMps[i].setName("生产者" + i);
            threadMps[i].start();

            threadMcs[i] = new ThreadMc(customerMc);
            threadMcs[i].setName("消费者" + i);
            threadMcs[i].start();
        }
    }
}

class ThreadMp extends Thread {
    private ProducerMp p;

    public ThreadMp(ProducerMp p) {
        this.p = p;
    }

    @SneakyThrows
    @Override
    public void run() {

        while (true) {
            p.setValue();
            sleep(1000L);
        }
    }
}

class ThreadMc extends Thread {
    private CustomerMc c;

    public ThreadMc(CustomerMc c) {
        this.c = c;
    }

    @SneakyThrows
    @Override
    public void run() {

        while (true) {
            c.getValue();
            sleep(1000L);
        }
    }
}
