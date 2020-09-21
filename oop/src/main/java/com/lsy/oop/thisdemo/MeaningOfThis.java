package com.lsy.oop.thisdemo;

/**
 * this指代当前调用对象
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/19
 */
public class MeaningOfThis {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            public void run() {
                int value = 10;
                // this指的是包含它的Runnable，而不是外面的类MeaningOfThi
                System.out.println(this.value);
            }
        };
        r.run();
    }
}