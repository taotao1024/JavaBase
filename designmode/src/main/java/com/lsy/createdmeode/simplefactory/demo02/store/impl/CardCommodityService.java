package com.lsy.createdmeode.simplefactory.demo02.store.impl;

import com.alibaba.fastjson.JSON;
import com.lsy.createdmeode.simplefactory.demo00.card.IQiYiCardService;
import com.lsy.createdmeode.simplefactory.demo02.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 爱奇艺卡片
 *
 * @author TT
 */
public class CardCommodityService implements ICommodity {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    /**
     * 模拟注入
     */
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        iQiYiCardService.grantToken(queryUserMobile(uId), bizId);

        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    /**
     * 获取用户电话
     *
     * @param uId 用户ID
     * @return
     */
    private String queryUserMobile(String uId) {
        return "15200101232";
    }

}
