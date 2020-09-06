package com.lsy.factorymethod.base.impl;

import com.lsy.factorymethod.base.BaseFactory;
import com.lsy.factorymethod.base.BaseOperation;

/**
 * 子工厂完成具体的实例化
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
public class FactoryAdd extends BaseFactory {
    @Override
    public BaseOperation createFactory() {
        return new OpeartionAdd();
    }
}
