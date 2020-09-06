package com.lsy.thread.volatiledemo;

/**
 * @author YY
 */
public class InCreaseDemo0 {
    /**
     * HSDIS工具 : 反编译 汇编
     * <p>
     * 汇编关键字 lock:m
     */
    private static volatile int m = 0;

    private static synchronized void increase() {
        m++;//非原子性操作
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            //10个线程
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    increase();
                    //System.out.println(m);
                }
            }).start();
        }//40 45 50 29 <=50
        System.out.println("result " + m);
    }
}
