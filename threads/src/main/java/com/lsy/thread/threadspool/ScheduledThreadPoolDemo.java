package com.lsy.thread.threadspool;

import java.util.concurrent.*;

/**
 * 可调度线程池
 *
 * @author YY
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            scheduledThreadPool.submit(new TaskDemo());
        }
        scheduledThreadPool.shutdown();
    }

    /*public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }*/
}
