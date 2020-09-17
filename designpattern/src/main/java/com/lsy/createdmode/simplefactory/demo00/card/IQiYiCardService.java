package com.lsy.createdmode.simplefactory.demo00.card;

/**
 * 模拟爱奇艺会员卡服务
 *
 * @author TT
 */
public class IQiYiCardService {
    /**
     * 发放卡片
     *
     * @param bindMobileNumber 用绑定户电话
     * @param cardId           卡片ID
     */
    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobileNumber + "，" + cardId);
    }
}
