package com.lsy.thread.threadspool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // 高3为表示状态
    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                2,
                3L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }

    /*public void execute(Runnable command) {
        if (command == null){ // 参数过滤
            throw new NullPointerException();
        }
        int c = ctl.get(); // 获取工作状态码
        if (workerCountOf(c) < corePoolSize) { // 1、当前线程总数量小于核心线程数
            if (addWorker(command, true)) //添加到核心线程池
                return;
            c = ctl.get();
        }
        if (isRunning(c) && workQueue.offer(command)) { // 2、当前线程为运行状态时 放入阻塞队列中
            int recheck = ctl.get(); // 获取状态码 第一次检测
            if (!isRunning(recheck) && remove(command)) // 获取状态码 第二次检测
                reject(command);  // 拒绝执行
            else if (workerCountOf(recheck) == 0)
                addWorker(null, false); // 执行任务
        } else if (!addWorker(command, false)) // 3、常识新建线程 失败则拒绝线程
            reject(command);
    }*/
}
