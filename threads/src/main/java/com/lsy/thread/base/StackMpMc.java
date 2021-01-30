package com.lsy.thread.base;

import lombok.SneakyThrows;

/**
 * 单生产者单消费者（SPSC）：操作栈
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/30
 */
public class StackMpMc {
    public static void main(String[] args) {
        int custThreadSize = 5;
        int prodThreadSize = 5;

        final MyStackM myStack = new MyStackM();
        final PM p = new PM(myStack);
        final CM c = new CM(myStack);
        final ProdThreadM[] threadSps = new ProdThreadM[prodThreadSize];
        final CustThreadM[] threadScs = new CustThreadM[custThreadSize];

        for (int i = 0; i < prodThreadSize; i++) {
            threadSps[i] = new ProdThreadM(p);
            threadSps[i].setName("生产者" + i);
            threadSps[i].start();
        }

        for (int i = 0; i < custThreadSize; i++) {
            threadScs[i] = new CustThreadM(c);
            threadScs[i].setName("消费者" + i);
            threadScs[i].start();
        }
    }
}


class ProdThreadM extends Thread {
    private PM p;

    public ProdThreadM(PM p) {
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

class CustThreadM extends Thread {
    private CM c;

    public CustThreadM(CM c) {
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

class PM {
    private MyStackM myStack;

    public PM(MyStackM myStack) {
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }
}

class CM {
    private MyStackM myStack;

    public CM(MyStackM myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        myStack.pop();
    }
}