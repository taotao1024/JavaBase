package com.lsy.thread.base;

import lombok.SneakyThrows;

/**
 * 单生产者单消费者（SPSC）：操作栈
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/30
 */
public class StackSpSc {
    public static void main(String[] args) {
//        int custThreadSize = 5;
        int custThreadSize = 1;
        int prodThreadSize = 1;

        final MyStack myStack = new MyStack();
        final P p = new P(myStack);
        final C c = new C(myStack);
        final ProdThread[] threadSps = new ProdThread[prodThreadSize];
        final CustThread[] threadScs = new CustThread[custThreadSize];

        for (int i = 0; i < prodThreadSize; i++) {
            threadSps[i] = new ProdThread(p);
            threadSps[i].setName("生产者" + i);
            threadSps[i].start();
        }

        for (int i = 0; i < custThreadSize; i++) {
            threadScs[i] = new CustThread(c);
            threadScs[i].setName("消费者" + i);
            threadScs[i].start();
        }
    }
}


class ProdThread extends Thread {
    private P p;

    public ProdThread(P p) {
        this.p = p;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            p.pushService();
            sleep(1000L);
        }
    }
}

class CustThread extends Thread {
    private C c;

    public CustThread(C c) {
        this.c = c;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            c.popService();
            sleep(1000L);
        }
    }
}

class P {
    private MyStack myStack;

    public P(MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }
}

class C {
    private MyStack myStack;

    public C(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        myStack.pop();
    }
}