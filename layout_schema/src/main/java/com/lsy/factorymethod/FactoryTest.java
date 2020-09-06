package com.lsy.factorymethod;

import com.lsy.factorymethod.base.BaseOperation;
import com.lsy.factorymethod.base.impl.FactoryAdd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * 简单工厂违反开闭原则。
 * <p/>
 * 工厂方法模式是简单工厂的进一步抽象,将类的实例化延迟到其子类。
 * <p/>
 * 客户端直接实例化子类工厂，添加功能需要修改客户端代码。
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
@RunWith(JUnit4.class)
public class FactoryTest {

    @Test
    public void testFactoryAdd() {
        BaseOperation factory = new FactoryAdd().createFactory();
        factory.setNumberA(1);
        factory.setNumberB(2);
        System.out.println(factory.getResult());
    }
}
