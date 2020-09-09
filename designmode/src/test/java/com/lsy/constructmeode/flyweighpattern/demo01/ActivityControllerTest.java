package com.lsy.constructmeode.flyweighpattern.demo01;

import com.alibaba.fastjson.JSON;
import com.lsy.constructmeode.flyweighpattern.demo02.Activity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class ActivityControllerTest {
    private Logger logger = LoggerFactory.getLogger(ActivityControllerTest.class);

    private ActivityController activityController = new ActivityController();

    @Test
    public void queryActivityInfo() {
        Long req = 10001L;
        Activity activity = activityController.queryActivityInfo(req);
        logger.info("测试结果：{} {}", req, JSON.toJSONString(activity));
    }
}