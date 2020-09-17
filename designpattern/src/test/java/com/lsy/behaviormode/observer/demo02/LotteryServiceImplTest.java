package com.lsy.behaviormode.observer.demo02;

import com.alibaba.fastjson.JSON;
import com.lsy.behaviormode.observer.demo01.LotteryService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class LotteryServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(LotteryServiceImplTest.class);

    @Test
    public void doDraw() {
        BaseLotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109876");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }
}