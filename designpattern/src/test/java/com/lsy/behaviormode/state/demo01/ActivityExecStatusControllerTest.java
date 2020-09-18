package com.lsy.behaviormode.state.demo01;

import com.alibaba.fastjson.JSON;
import com.lsy.behaviormode.state.demo00.ActivityService;
import com.lsy.behaviormode.state.demo00.Status;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class ActivityExecStatusControllerTest {


    private Logger logger = LoggerFactory.getLogger(ActivityExecStatusControllerTest.class);

    @Test
    public void test() {

        // 初始化数据
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);

        ActivityExecStatusController activityExecStatusController = new ActivityExecStatusController();
        Result resultRefuse = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Refuse);

        logger.info("测试结果(编辑中To审核拒绝)：{}", JSON.toJSONString(resultRefuse));

        Result resultCheck = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Check);
        logger.info("测试结果(编辑中To提交审核)：{}", JSON.toJSONString(resultCheck));

    }
}