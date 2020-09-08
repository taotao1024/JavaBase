package com.lsy.constructmeode.bridgepattern.demo02.pay.channel;

import com.lsy.constructmeode.bridgepattern.demo02.pay.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 支付抽象类
 */
public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    protected IPayMode payMode;

    /**
     * 构造方法
     *
     * @param payMode
     */
    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
