package com.lsy.thread.volatiledemo;

/**
 * 标志状态 开关模式
 *
 * @author YY
 */
public class ShutDownDemo extends Thread {
    private volatile boolean started = false;

    @Override
    public void run() {
        while (started) {
            dowork();
        }
    }

    public void shutdown() {
        started = false;
    }

    private void dowork() {
        started = true;
    }
}
