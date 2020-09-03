package com.lsy.createdmeode.simplefactory.demo01;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * 奖品发放服务测试
 * @author TT
 */
public class PrizeControllerTest {

    /**
     * 日志对象
     */
    private Logger logger = LoggerFactory.getLogger(PrizeControllerTest.class);
    /**
     * 奖品发放服务端服务端
     */
    PrizeController prizeController;

    @Before
    public void testBefore() {
        prizeController = new PrizeController();
    }

    /**
     * 模拟发放优惠券测试
     */
    @Test
    public void testAwardToUser01() {
        System.out.println("模拟发放优惠券测试\n");
        // 模拟数据
        AwardReq awardRequest = new AwardReq();
        awardRequest.setuId("10001");
        awardRequest.setAwardType(1);
        awardRequest.setAwardNumber("EGM1023938910232121323432");
        awardRequest.setBizId("791098764902132");
        // 发送请求
        AwardRes awardRes01 = prizeController.awardToUser(awardRequest);
        logger.info("请求参数：{}", JSON.toJSON(awardRequest));
        logger.info("测试结果：{}", JSON.toJSON(awardRes01));
    }

    /**
     * 模拟方法实物商品
     */
    @Test(timeout = 1000)
    public void testAwardToUser02() {
        System.out.println("模拟方法实物商品\n");
        // 模拟数据
        AwardReq awardRequest = new AwardReq();
        awardRequest.setuId("10001");
        awardRequest.setAwardType(2);
        awardRequest.setAwardNumber("9820198721311");
        awardRequest.setBizId("1023000020112221113");
        awardRequest.setExtMap(new HashMap<String, String>(4) {{
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "山西省.显示市.莲湖区区.西关正街街道.檀溪苑小区.#18-2109");
        }});
        // 发送请求
        AwardRes awardRes02 = prizeController.awardToUser(awardRequest);
        logger.info("请求参数：{}", JSON.toJSON(awardRequest));
        logger.info("测试结果：{}", JSON.toJSON(awardRes02));
    }

    /**
     * 模拟第三方兑换卡(爱奇艺)
     */
    @Test
    public void testAwardToUser03() {
        System.out.println("第三方兑换卡(爱奇艺)\n");
        // 模拟数据
        AwardReq awardRequest = new AwardReq();
        awardRequest.setuId("10001");
        awardRequest.setAwardType(3);
        awardRequest.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");
        // 发送请求
        AwardRes awardRes03 = prizeController.awardToUser(awardRequest);
        logger.info("请求参数：{}", JSON.toJSON(awardRequest));
        logger.info("测试结果：{}", JSON.toJSON(awardRes03));
    }

}