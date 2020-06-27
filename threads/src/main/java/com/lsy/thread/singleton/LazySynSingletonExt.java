package com.lsy.thread.singleton;

/**
 * 懒汉加锁模式性能改进
 * <p>
 * 优势：减初始化压力
 * 劣势：线程安全 不能保证唯一性 性能差有所提升
 * <p>
 *
 * @author YY
 */
public class LazySynSingletonExt {
    private static LazySynSingletonExt instance = null;

    private LazySynSingletonExt() {
    }

    /**
     * 返回实例对象
     * <p>
     * 方法锁
     * <p>
     * flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     *
     * @return 实例对象
     */
    public static LazySynSingletonExt getInstance() {
        if (null == instance) {
            synchronized (LazySynSingletonExt.class) {
                instance = new LazySynSingletonExt();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        final int maxThreads = 20;
        for (int i = 0; i < maxThreads; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + LazySynSingletonExt.getInstance());
            }).start();
        }
    }
}
