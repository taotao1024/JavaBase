package com.lsy.behaviormode.strategy.demo02.impl;


import com.lsy.behaviormode.strategy.demo02.ICouponDiscount;

import java.math.BigDecimal;

/**
 * 直减
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/18
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }

}
