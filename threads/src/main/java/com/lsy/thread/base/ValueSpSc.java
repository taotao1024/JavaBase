package com.lsy.thread.base;

import lombok.SneakyThrows;

/**
 * 单生产者单消费者（SPSC）：操作值
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/30
 */
public class ValueSpSc {
    public static void main(String[] args) {
        final String lock = new String();
        new ThreadP(new ProducerSp(lock)).start();
        new ThreadC(new CustomerSc(lock)).start();
    }
}

class ThreadP extends Thread {
    private ProducerSp p;

    public ThreadP(ProducerSp p) {
        this.p = p;
    }

    @SneakyThrows
    @Override
    public void run() {

        while (true) {
            p.setValue();
            sleep(2000L);
        }
    }
}

class ThreadC extends Thread {
    private CustomerSc c;

    public ThreadC(CustomerSc c) {
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
