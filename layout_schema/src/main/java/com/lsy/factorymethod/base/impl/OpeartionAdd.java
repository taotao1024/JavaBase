package com.lsy.factorymethod.base.impl;


import com.lsy.factorymethod.base.BaseOperation;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
public class OpeartionAdd extends BaseOperation {
    @Override
    public double getResult() {
        double result = 0;
        result = super.getNumberA() + super.getNumberB();
        return result;
    }
}
