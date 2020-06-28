package com.lsy.thread.threadspool;

import java.util.concurrent.*;

/**
 * 单利线程池
 *
 * @author YY
 */
public class SingleThreadExecutorDemo {

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            singleThreadExecutor.submit(new TaskDemo());
        }
        singleThreadExecutor.shutdown();

        while (!singleThreadExecutor.isTerminated()) {
            System.out.println("进入队列");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("执行结束");
    }

    /*public static ExecutorService newSingleThreadExecutor() {
        return new Executors.FinalizableDelegatedExecutorService
                (new ThreadPoolExecutor(1, 1,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>()));
    }*/
}
