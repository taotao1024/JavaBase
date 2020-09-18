package com.lsy.behaviormode.strategy.demo02;

import java.math.BigDecimal;

/**
 * 内容
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/18
 */
public class Context<T> {
    /**
     * 折扣方式
     */
    private ICouponDiscount<T> couponDiscount;

    /**
     * 构造函数
     *
     * @param couponDiscount 折扣方式
     */
    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    /**
     * 折扣后
     *
     * @param couponInfo 折扣方式
     * @param skuPrice   金额
     * @return 折扣后的金额
     */
    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }

}
