package com.lsy.constructmeode.adaptermode.demo02.impl;


import com.lsy.constructmeode.adaptermode.demo00.service.PopOrderService;
import com.lsy.constructmeode.adaptermode.demo02.OrderAdapterService;

public class PopOrderAdapterServiceImpl implements OrderAdapterService {

    private PopOrderService popOrderService = new PopOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
