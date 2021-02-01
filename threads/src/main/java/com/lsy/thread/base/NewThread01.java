package com.lsy.thread.base;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.junit.internal.runners.statements.RunAfters;

import javax.management.relation.RoleInfo;
import javax.swing.plaf.SliderUI;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yuanyuan
 * @version 1.0
 * @date 2021/02/01
 */
public class NewThread01 {
    public static void main(String[] args) throws InterruptedException {
        final UseConditionWaitNotify useConditionWaitNotify = new UseConditionWaitNotify();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                useConditionWaitNotify.await();
            }
        };
        final Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
            threads[i].setName("当前为" + i + "线程");
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        Thread.sleep(1000);
    }
}
