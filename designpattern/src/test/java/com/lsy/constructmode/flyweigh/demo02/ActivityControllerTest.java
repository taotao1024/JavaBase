package com.lsy.constructmode.flyweigh.demo02;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivityControllerTest {


    private Logger logger = LoggerFactory.getLogger(ActivityControllerTest.class);

    private ActivityController activityController = new ActivityController();

    @Test
    public void queryActivityInfo() throws InterruptedException {
        for (int idx = 0; idx < 10; idx++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            logger.info("测试结果：{} {}", req, JSON.toJSONString(activity));
            Thread.sleep(1200);
        }


    }
}