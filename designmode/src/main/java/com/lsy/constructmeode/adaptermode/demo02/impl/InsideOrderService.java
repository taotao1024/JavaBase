package com.lsy.constructmeode.adaptermode.demo02.impl;


import com.lsy.constructmeode.adaptermode.demo00.service.OrderService;
import com.lsy.constructmeode.adaptermode.demo02.OrderAdapterService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
