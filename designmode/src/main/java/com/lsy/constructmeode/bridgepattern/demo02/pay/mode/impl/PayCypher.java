package com.lsy.constructmeode.bridgepattern.demo02.pay.mode.impl;

import com.lsy.constructmeode.bridgepattern.demo02.pay.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 密码
 */
public class PayCypher implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    public boolean security(String uId) {
        logger.info("密码支付，风控校验环境安全");
        return true;
    }

}
