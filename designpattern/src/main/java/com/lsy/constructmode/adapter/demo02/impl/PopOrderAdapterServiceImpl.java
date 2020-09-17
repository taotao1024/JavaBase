package com.lsy.constructmode.adapter.demo02.impl;


import com.lsy.constructmode.adapter.demo00.service.PopOrderService;
import com.lsy.constructmode.adapter.demo02.OrderAdapterService;

public class PopOrderAdapterServiceImpl implements OrderAdapterService {

    private PopOrderService popOrderService = new PopOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
