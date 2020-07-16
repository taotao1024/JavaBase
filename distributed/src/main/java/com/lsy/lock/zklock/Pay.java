package com.lsy.lock.zklock;

/**
 * 模拟支付系统
 * @author YY
 */
public class Pay {
    /**
     * 支付成功
     */
    public void pay() {
        System.out.println(Thread.currentThread().getName() + " 支付成功");
    }
}
