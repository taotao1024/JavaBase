package com.lsy.constructmeode.flyweigh.demo01;

import com.lsy.constructmeode.flyweigh.demo02.Activity;
import com.lsy.constructmeode.flyweigh.demo02.Stock;

import java.util.Date;

/**
 * 活动
 */
public class ActivityController {
    /**
     * 查询活动信息
     *
     * @param id ActivityId
     * @return Activity
     */
    public Activity queryActivityInfo(Long id) {
        // 模拟从实际业务应用从接口中获取活动信息
        Activity activity = new Activity();
        activity.setId(10001L);
        activity.setName("图书嗨乐");
        activity.setDesc("图书优惠券分享激励分享活动第二期");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(1000, 1));
        return activity;
    }

}
