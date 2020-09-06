package com.lsy.thread.threadspool;

import java.util.concurrent.*;

/**
 * 固定大小线程池
 *
 * @author YY
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        int taskMax = 20;
        for (int i = 0; i < taskMax; i++) {
            pool.submit(new TaskDemo());
        }
        pool.shutdown();
    }
    /*public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }*/
}
