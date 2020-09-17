package com.lsy.constructmode.flyweigh.demo02;


import com.lsy.constructmode.flyweigh.demo02.util.RedisUtils;

/**
 * @author TT
 */
public class ActivityController {

    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从Redis中获取库存变化信息
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}
