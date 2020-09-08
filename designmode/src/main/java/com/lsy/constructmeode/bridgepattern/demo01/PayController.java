package com.lsy.constructmeode.bridgepattern.demo01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author TT
 */
public class PayController {

    private Logger logger = LoggerFactory.getLogger(PayController.class);

    /**
     * 支付
     *
     * @param uId         用户ID
     * @param tradeId     贸易ID
     * @param amount      金额
     * @param channelType 支付通道类型：支付宝、微信、银联
     * @param modeType    支付方式：密码、指纹、人脸
     * @return
     */
    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {
        // 微信支付
        if (1 == channelType) {
            logger.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modeType) {
                logger.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                logger.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                logger.info("指纹支付，风控校验指纹信息");
            }
        }
        // 支付宝支付
        else if (2 == channelType) {
            logger.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modeType) {
                logger.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                logger.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                logger.info("指纹支付，风控校验指纹信息");
            }
        }
        return true;
    }

}
