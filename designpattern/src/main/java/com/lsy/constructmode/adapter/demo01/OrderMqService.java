package com.lsy.constructmode.adapter.demo01;

import com.alibaba.fastjson.JSON;
import com.lsy.constructmode.adapter.demo00.mq.OrderMq;

public class OrderMqService {

    public void onMessage(String message) {

        OrderMq mq = JSON.parseObject(message, OrderMq.class);

        mq.getUid();
        mq.getOrderId();
        mq.getCreateOrderTime();

        // ... 处理自己的业务
    }

}
