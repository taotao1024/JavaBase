package com.lsy.thread.threadspool;

import java.util.concurrent.*;

/**
 * 缓存线程池
 *
 * @author YY
 */
public class CachedPoolDemo {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            //创建任务
            Runnable task = new TaskDemo();
            //把任务交给pool去执行
            pool.execute(task);
        }
        pool.shutdown();
    }
    /*public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }*/
}
