package com.lsy.factorymethod.base;


/**
 * 将工厂的创建延迟到子类去实现
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
public abstract class BaseFactory {
    /**
     * 基础工厂创建子工厂
     *
     * @return
     */
    public abstract BaseOperation createFactory();
}
