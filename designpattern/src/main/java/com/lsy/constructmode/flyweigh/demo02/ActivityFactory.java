package com.lsy.constructmode.flyweigh.demo02;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class ActivityFactory {
    /**
     * 通过map缓存查询过的信息
     */
    static Map<Long, Activity> activityMap = new HashMap<Long, Activity>();

    /**
     * 获取不变的活动信息
     *
     * @param id ActivityId
     * @return Activity
     */
    public static Activity getActivity(Long id) {
        Activity activity = activityMap.get(id);
        if (null == activity) {
            // 模拟从实际业务应用从接口中获取活动信息
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("图书嗨乐");
            activity.setDesc("图书优惠券分享激励分享活动第二期");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }
        return activity;
    }

}
