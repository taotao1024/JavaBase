package com.lsy.simplefactory.demo02;

import com.lsy.simplefactory.demo02.store.ICommodity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.Parameterized;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class StoreFactoryTest {
    /**
     * 工厂
     */
    StoreFactory storeFactory = new StoreFactory();

    @Test(timeout = 1000)
    public void testCreateCommodityFactory01() throws Exception {
        // 1. 优惠券
        ICommodity commodityService_1 = storeFactory.createCommodityFactory(1);

        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);


    }

    @Test(timeout = 1000)
    public void testCreateCommodityFactory02() throws Exception {
        // 2. 实物商品
        ICommodity commodityService_2 = storeFactory.createCommodityFactory(2);

        Map<String, String> extMap = new HashMap<String, String>();
        extMap.put("consigneeUserName", "谢飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");

        commodityService_2.sendCommodity("10001", "9820198721311", "1023000020112221113", new HashMap<String, String>() {{
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        }});
    }

    @Test(timeout = 1000)
    public void testCreateCommodityFactory03() throws Exception {
        // 3. 第三方兑换卡(爱奇艺)
        ICommodity commodityService_3 = storeFactory.createCommodityFactory(3);
        commodityService_3.sendCommodity("10001", "AQY1xjkUodl8LO975GdfrYUio", null, null);
    }
}