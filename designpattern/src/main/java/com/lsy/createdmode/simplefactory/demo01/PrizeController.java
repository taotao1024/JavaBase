package com.lsy.createdmode.simplefactory.demo01;

import com.alibaba.fastjson.JSON;
import com.lsy.createdmode.simplefactory.demo00.card.IQiYiCardService;
import com.lsy.createdmode.simplefactory.demo00.coupon.CouponResult;
import com.lsy.createdmode.simplefactory.demo00.coupon.CouponService;
import com.lsy.createdmode.simplefactory.demo00.goods.DeliverReq;
import com.lsy.createdmode.simplefactory.demo00.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 奖品发放服务端服务端
 *
 * @author TT
 */
public class PrizeController {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(PrizeController.class);

    /**
     * 成功标识
     */
    private final String SUCCESS = "0000";
    /**
     * 爱奇艺卡片标识
     */
    private final int IQY_CODE = 3;
    /**
     * 优惠卷标识
     */
    private final int COUPON_CODE = 2;
    /**
     * 实体礼物标识
     */
    private final int GOODS_CODE = 1;

    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            logger.info("奖品发放开始{}。req:{}", req.getuId(), reqJson);
            // 按照不同类型方法商品[1优惠券、2实物商品、3第三方兑换卡(爱奇艺)]
            if (req.getAwardType() == GOODS_CODE) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getuId(), req.getAwardNumber(), req.getBizId());
                if (SUCCESS.equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            } else if (req.getAwardType() == COUPON_CODE) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getuId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == IQY_CODE) {
                String bindMobileNumber = queryUserPhoneNumber(req.getuId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            logger.info("奖品发放完成{}。", req.getuId());
        } catch (Exception e) {
            logger.error("奖品发放失败{}。req:{}", req.getuId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }

        return awardRes;
    }

    private String queryUserName(String uId) {
        return "张三";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }


}
