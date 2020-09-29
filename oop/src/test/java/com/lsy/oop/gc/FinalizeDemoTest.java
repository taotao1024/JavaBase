package com.lsy.oop.gc;

import org.junit.Test;

public class FinalizeDemoTest {

    @Test
    public void info() {
        // 创建finalize对象进入可恢复状态
        new FinalizeDemo();
        // 通知系统进行资源回收
        // System.gc();
        //Runtime.getRuntime().gc();
        //System.runFinalization();
        FinalizeDemo.ft.info();
    }
}