package com.lsy.thread.synchronizedemo;

import lombok.SneakyThrows;

import java.io.File;

/**
 * 测试程序
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/04
 */
public class Test {
    public synchronized static void main(String[] args) {
//        Test.thread01();
//        Test.thread02();
        final HasSelfPrivateNum has1 = new Test().new HasSelfPrivateNum();
        final HasSelfPrivateNum has2 = new Test().new HasSelfPrivateNum();
        final threadA threadA = new Test().new threadA(has1);
        threadA.start();
        final threadB threadB = new Test().new threadB(has2);
        threadB.start();
    }

    private static void thread01() {
        final Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("线程1");
        thread.start();
    }

    private static void thread02() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((int) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class HasSelfPrivateNum {
        private int num = 0;


        @SneakyThrows
        synchronized public void setNum(String username) {
            if ("a".equals(username)) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2000);
            } else {
                num = 999;
                System.out.println("b set over");
            }
            System.out.println(username + " 的num :" + num);
        }
    }

    class threadA extends Thread {
        HasSelfPrivateNum hasSelfPrivateNum;

        public threadA(HasSelfPrivateNum hasSelfPrivateNum) {
            super();
            this.hasSelfPrivateNum = hasSelfPrivateNum;

        }

        @Override
        public void run() {
            super.run();
            hasSelfPrivateNum.setNum("a");
        }
    }

    class threadB extends Thread {
        HasSelfPrivateNum hasSelfPrivateNum;

        public threadB(HasSelfPrivateNum hasSelfPrivateNum) {
            super();
            this.hasSelfPrivateNum = hasSelfPrivateNum;

        }

        @Override
        public void run() {
            super.run();
            hasSelfPrivateNum.setNum("b");
        }
    }

}
