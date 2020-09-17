package com.lsy.behaviormode.observer.demo01;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseLotteryServiceTest {

    private Logger logger = LoggerFactory.getLogger(BaseLotteryServiceTest.class);

    @Test
    public void doDraw() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.doDraw("2765789109876");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }

}