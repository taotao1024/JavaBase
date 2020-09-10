package com.lsy.createdmeode.simplefactory.demo00.coupon;

/**
 * 模拟优惠券服务
 * @author TT
 */
public class CouponService {
    /**
     * 发放优惠卷
     * @param uId 用户ID
     * @param couponNumber 优惠卷数量
     * @param uuid uuid
     * @return 优惠卷发送结果
     */
    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + uId + "," + couponNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }

}
