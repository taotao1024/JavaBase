package com.lsy.constructmode.adapter.demo02.impl;


import com.lsy.constructmode.adapter.demo00.service.OrderService;
import com.lsy.constructmode.adapter.demo02.OrderAdapterService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
