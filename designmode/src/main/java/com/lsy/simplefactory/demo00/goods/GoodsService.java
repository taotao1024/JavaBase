package com.lsy.simplefactory.demo00.goods;

import com.alibaba.fastjson.JSON;

/**
 * 模拟实物商品服务
 *
 * @author TT
 */
public class GoodsService {
    /**
     * 模拟发送实体商品
     *
     * @param req 商品请求信息
     * @return 发送实体商品结果
     */
    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }

}
