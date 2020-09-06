package com.lsy.strategypattern;

import com.lsy.strategypattern.base.BaseStrategy;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
public class CashContext {

    BaseStrategy bs;

    public CashContext(BaseStrategy bs) {
        //可以根据条件判定  选择策略
        this.bs = bs;
    }

    /**
     * 调用策略
     */
    public void getStrategyImpl() {
        this.bs.algorithmInterface();
    }

}
