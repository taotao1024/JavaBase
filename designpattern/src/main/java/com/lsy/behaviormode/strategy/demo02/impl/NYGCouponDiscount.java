package com.lsy.behaviormode.strategy.demo02.impl;


import com.lsy.behaviormode.strategy.demo02.ICouponDiscount;

import java.math.BigDecimal;

/**
 * n元购买
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/18
 */
public class NYGCouponDiscount implements ICouponDiscount<Double> {

    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }

}
