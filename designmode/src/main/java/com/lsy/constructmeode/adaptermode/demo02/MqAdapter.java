package com.lsy.constructmeode.adaptermode.demo02;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 适配消息
 *
 * @author TT
 */
public class MqAdapter {
    /**
     * 公共消息
     *
     * @param strJson 消息
     * @param link    Map映射
     * @return 通用消息
     * @throws NoSuchMethodException     没有这样的方法异常
     * @throws InvocationTargetException 调用目标异常
     * @throws IllegalAccessException    非法访问异常
     */
    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    public static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }

}
