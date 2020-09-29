package com.lsy.oop.gc;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/29
 */
public class FinalizeDemo {
    public static FinalizeDemo ft = null;

    public void info() {
        System.out.println("测试资源清理的finalize方法");
    }

    @Override
    protected void finalize() throws Throwable {
        ft = this;
    }

    public static void main(String[] args) {
        // 创建finalize对象进入可恢复状态
        new FinalizeDemo();
        /* 通知系统进行资源回收
         * 如果不通知系统GC,调用finalize方法,系统不会进行GC,ft对象的索引为空,无法调用info()方法.
         */
        //System.gc();
        // 强制垃圾回收机制,调用可恢复对象的finalize()方法
        Runtime.getRuntime().gc();
        System.runFinalization();
        ft.info();
    }
}
