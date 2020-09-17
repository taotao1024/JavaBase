package com.lsy.constructmode.adapter.demo00.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自营订单服务
 *
 * @author TT
 */
public class OrderService {
    /**
     * 日志
     */
    private final Logger logger = LoggerFactory.getLogger(PopOrderService.class);

    /**
     * 查询用户订单总数
     *
     * @param userId
     * @return 用户数量
     */
    public long queryUserOrderCount(String userId) {
        logger.info("自营商家，查询用户的订单是否为首单：{}", userId);
        return 10L;
    }

}
