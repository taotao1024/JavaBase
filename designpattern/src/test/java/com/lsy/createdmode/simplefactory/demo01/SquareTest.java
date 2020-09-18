package com.lsy.createdmode.simplefactory.demo01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * 运行器 测试组
 * @author TT
 */
@RunWith(Parameterized.class)
public class SquareTest {

    PrizeController prizeController = new PrizeController();
    private AwardReq awardReq;
    private AwardRes awardRes;

    @Parameters
    public static Collection testDataParameters() {
        // 模拟数据01
        AwardReq awardRequest01 = new AwardReq();
        awardRequest01.setuId("10001");
        awardRequest01.setAwardType(2);
        awardRequest01.setAwardNumber("9820198721311");
        awardRequest01.setBizId("1023000020112221113");
        awardRequest01.setExtMap(new HashMap<String, String>(4) {{
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "山西省.显示市.莲湖区区.西关正街街道.檀溪苑小区.#18-2109");
        }});
        // 模拟数据02
        AwardReq awardRequest02 = new AwardReq();
        awardRequest02.setuId("10001");
        awardRequest02.setAwardType(1);
        awardRequest02.setAwardNumber("EGM1023938910232121323432");
        awardRequest02.setBizId("791098764902132");

        // 模拟数据03
        AwardReq awardRequest03 = new AwardReq();
        awardRequest03.setuId("10001");
        awardRequest03.setAwardType(3);
        awardRequest03.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");

        return Arrays.asList(new Object[][]{
                {awardRequest01, new AwardRes("0000", "发放成功")},
                {awardRequest02, new AwardRes("0000", "发放成功")},
                {awardRequest03, new AwardRes("0000", "发放成功")},
        });
    }

    /**
     * 构造方法，对变量进行初始化
     *
     * @param param  入参
     * @param result 结果
     */
    public SquareTest(AwardReq param, AwardRes result) {
        this.awardReq = param;
        this.awardRes = result;
    }

    @Test(timeout = 3000)
    public void square() {
        prizeController.awardToUser(awardReq);
        //assertEquals(awardRes, prizeController.awardToUser(awardReq));
    }
}