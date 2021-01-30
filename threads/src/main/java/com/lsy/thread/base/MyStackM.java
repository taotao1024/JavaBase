package com.lsy.thread.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作栈
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/30
 */
public class MyStackM {
    private List list = new ArrayList(1);

    synchronized public void push() {
        try {
            while (list.size() == 1) {
                // 有值 等待
                this.wait();
            }
            list.add("Push Value :" + Math.random());
            this.notifyAll();
            System.out.println("push = " + list.size());
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }

    synchronized public void pop() {
        try {
            while (list.size() == 0) {
                // 没有值 等待
                this.wait();
            }
            System.out.println("pop = " + list.get(0));
            list.remove(0);
            System.out.println("pop = " + list.size());
            this.notifyAll();
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }
}
