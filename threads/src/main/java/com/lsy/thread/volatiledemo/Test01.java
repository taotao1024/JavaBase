package com.lsy.thread.volatiledemo;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import org.apache.log4j.helpers.FormattingInfo;

import javax.lang.model.element.VariableElement;

/**
 * 原子性测试
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2021/01/25
 */
public class Test01 {

    public static void main(String[] args) {
        MyThread[] myThreadsArrays = new MyThread[100];
        for (int i = 0; i < myThreadsArrays.length; i++) {
            myThreadsArrays[i]=new MyThread();
        }
        for (int i = 0; i < 100; i++) {
            myThreadsArrays[i].start();
        }
    }
}

class MyThread extends Thread {
    volatile public static int count;

//    synchronized private static void add() {
     private static void add() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count =" + count);
    }

    @Override
    public void run() {
        add();
    }
}
