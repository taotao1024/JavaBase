package com.lsy.createdmeode.simplefactory.demo02.store.impl;

import com.alibaba.fastjson.JSON;
import com.lsy.createdmeode.simplefactory.demo00.coupon.CouponResult;
import com.lsy.createdmeode.simplefactory.demo00.coupon.CouponService;
import com.lsy.createdmeode.simplefactory.demo02.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 优惠卷
 * @author TT
 */
public class CouponCommodityService implements ICommodity {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);
    /**
     * 模拟注入
     */
    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);

        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals((couponResult).getCode())) {
            throw new RuntimeException(couponResult.getInfo());
        }
    }

}
