package com.lsy.strategypattern;

import com.lsy.strategypattern.base.impl.StrategyA;
import com.lsy.strategypattern.base.impl.StrategyB;
import com.lsy.strategypattern.base.impl.StrategyC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
@RunWith(JUnit4.class)
public class StrategyTest {
    @Test
    public void testStrategyA() {
        new CashContext(new StrategyA()).getStrategyImpl();
    }

    @Test
    public void testStrategyB() {
        new CashContext(new StrategyB()).getStrategyImpl();
    }

    @Test
    public void testStrategyC() {
        new CashContext(new StrategyC()).getStrategyImpl();
    }

}
