package com.lsy.simplefactory.demo02.store.impl;

import com.alibaba.fastjson.JSON;
import com.lsy.simplefactory.demo00.goods.DeliverReq;
import com.lsy.simplefactory.demo00.goods.GoodsService;
import com.lsy.simplefactory.demo02.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 实体礼物
 *
 * @author TT
 */
public class GoodsCommodityService implements ICommodity {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);
    /**
     * 模拟注入
     */
    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        // 数据封装
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", isSuccess);

        if (!isSuccess) {
            throw new RuntimeException("实物商品发放失败");
        }
    }

    /**
     * 获取用户名
     *
     * @param uId
     * @return
     */
    private String queryUserName(String uId) {
        return "花花";
    }

    /**
     * 获取用户电话
     *
     * @param uId
     * @return
     */
    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
