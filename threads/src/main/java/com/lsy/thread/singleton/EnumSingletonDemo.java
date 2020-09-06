package com.lsy.thread.singleton;

/**
 * 枚举+持有者
 * <p>
 * 优势：线程安全 唯一性 性能好 懒加载
 * 劣势：抽象 难理解
 * <p>
 *
 * @author YY
 */
public class EnumSingletonDemo {
    /**
     * 私有化构造函数
     */
    private EnumSingletonDemo() {
    }


    public static EnumSingletonDemo getInstance() {
        return EnumHolder.INSTANCE.instance;
        //return EnumHolder.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        final int maxThreads = 10;
        for (int i = 0; i < maxThreads; i++) {
            new Thread(() -> {
                EnumSingletonDemo instance = EnumSingletonDemo.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + instance);
            }).start();
        }
    }

    //---------------------- 内部类开始 ----------------------

    /**
     * 通过内部类实现懒加载
     */
    private enum EnumHolder {
        /**
         * 代表着EnumHolder类型
         */
        INSTANCE;
        /**
         * 懒加载 常量 成员变量
         */
        private EnumSingletonDemo instance;

        /**
         * 实例化
         */
        EnumHolder() {
            instance = new EnumSingletonDemo();
        }

        /**
         * 获取实例化
         *
         * @return 实例化对象
         */
        private EnumSingletonDemo getInstance() {
            return instance;
        }
    }
    //---------------------- 内部类结束 ----------------------


}
