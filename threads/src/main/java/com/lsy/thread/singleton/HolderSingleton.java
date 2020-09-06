package com.lsy.thread.singleton;

/**
 * 持有者模式 DCL改进
 * <p>
 * 优势：延迟加载 同步性 唯一性 性能好 不用锁实现了线程安全
 * 劣势：
 * <p>
 *
 * @author YY
 */
public class HolderSingleton {

    /**
     * 返回实例对象
     * <p>
     * 内部静态类 将实例化操作延迟到静态内部类
     */
    public static HolderSingleton getInstance() {
        return Holder.instance;
    }

    /**
     * 静态内部类进行实例化
     * <p>
     * 会被加载 但是不会被实例化 只有调用时才会被实例化
     * <p>
     * 参考Java编程思想 JVM类加载子系统
     */
    private static class Holder {
        private static HolderSingleton instance = new HolderSingleton();
    }

    public static void main(String[] args) {
        final int maxThreads = 10;
        for (int i = 0; i < maxThreads; i++) {
            new Thread(() -> {
                HolderSingleton instance = HolderSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + instance);
            }).start();
        }
    }
}
