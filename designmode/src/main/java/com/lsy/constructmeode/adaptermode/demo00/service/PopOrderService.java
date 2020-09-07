package com.lsy.constructmeode.adaptermode.demo00.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * POP商家订单服务
 *
 * @author TT
 */
public class PopOrderService {

    private Logger logger = LoggerFactory.getLogger(PopOrderService.class);

    /**
     * 查询是否为首单
     *
     * @param uId 用户id
     * @return  Boolean
     */
    public boolean isFirstOrder(String uId) {
        logger.info("POP商家，查询用户的订单是否为首单：{}", uId);
        return true;
    }

}
