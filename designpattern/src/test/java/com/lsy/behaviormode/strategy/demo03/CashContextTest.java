package com.lsy.behaviormode.strategy.demo03;

import com.lsy.behaviormode.strategy.demo03.base.StrategyA;
import com.lsy.behaviormode.strategy.demo03.base.StrategyB;
import com.lsy.behaviormode.strategy.demo03.base.StrategyC;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashContextTest {

    @Test
    public void getStrategyImpl() {
    }

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