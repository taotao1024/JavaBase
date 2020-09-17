package com.lsy.constructmode.adapter.demo01;

import com.alibaba.fastjson.JSON;
import com.lsy.constructmode.adapter.demo00.mq.PopOrderDelivered;

public class PopOrderDeliveredService {

    public void onMessage(String message) {

        PopOrderDelivered mq = JSON.parseObject(message, PopOrderDelivered.class);

        mq.getuId();
        mq.getOrderId();
        mq.getOrderTime();

        // ... 处理自己的业务
    }

}
