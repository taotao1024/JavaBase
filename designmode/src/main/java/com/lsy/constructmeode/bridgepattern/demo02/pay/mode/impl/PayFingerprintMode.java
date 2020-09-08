package com.lsy.constructmeode.bridgepattern.demo02.pay.mode.impl;

import com.lsy.constructmeode.bridgepattern.demo02.pay.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 指纹
 */
public class PayFingerprintMode implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    public boolean security(String uId) {
        logger.info("指纹支付，风控校验指纹信息");
        return true;
    }

}
