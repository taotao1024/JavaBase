package com.lsy.createdmode.simplefactory.demo03;

import com.lsy.createdmode.simplefactory.demo03.base.BaseOperation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 简单工厂完成了类的实例化，并且包含了必要的逻辑，降低了客户端和工厂的解耦。
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
public class OperationFactoryTest {

    @Test
    public void createFactory() {
    }

    @Test
    public void testFactoryAdd() {
        BaseOperation baseFactory = new OperationFactory().createFactory(1);
        baseFactory.setNumberA(1);
        baseFactory.setNumberB(2);
        System.out.println(baseFactory.getResult());
    }

    @Test
    public void testFactorySub() {
        BaseOperation baseFactory = new OperationFactory().createFactory(2);
        baseFactory.setNumberA(1);
        baseFactory.setNumberB(2);
        System.out.println(baseFactory.getResult());
    }
}