package com.lsy.constructmeode.adapter.demo02.impl;


import com.lsy.constructmeode.adapter.demo00.service.PopOrderService;
import com.lsy.constructmeode.adapter.demo02.OrderAdapterService;

public class PopOrderAdapterServiceImpl implements OrderAdapterService {

    private PopOrderService popOrderService = new PopOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
