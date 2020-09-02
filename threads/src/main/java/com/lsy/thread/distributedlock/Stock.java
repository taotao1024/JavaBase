package com.lsy.thread.distributedlock;

/**
 * 模拟库存系统
 * @author YY
 */
public class Stock {

    private static Integer COUNT = 1;

    /**
     * 减库存操作
     *
     * @return
     */
    public boolean reduceStock() {
        if (COUNT > 0) {
            COUNT--;
            return true;
        }
        return false;
    }
}
