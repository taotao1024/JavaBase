package com.lsy.simplefactory.demo02.store;

import java.util.Map;

/**
 * 商品接口
 *
 * @author TT
 */
public interface ICommodity {
    /**
     * 发放商品
     *
     * @param uId         用户ID
     * @param commodityId 商品ID
     * @param bizId       ID
     * @param extMap      描述
     * @throws Exception
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}
