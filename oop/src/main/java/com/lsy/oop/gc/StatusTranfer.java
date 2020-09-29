package com.lsy.oop.gc;

/**
 * GC回收
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/29
 */
public class StatusTranfer {
    public void test() {
        String init_string = new String("Init String");
        init_string = "新的引用";
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("系统正在回收对象ing");
    }
}
