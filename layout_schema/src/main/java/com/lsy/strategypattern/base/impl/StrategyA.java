package com.lsy.strategypattern.base.impl;

import com.lsy.strategypattern.base.BaseStrategy;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
public class StrategyA extends BaseStrategy {
    @Override
    public void algorithmInterface() {
        System.out.println("算法A");
    }
}
