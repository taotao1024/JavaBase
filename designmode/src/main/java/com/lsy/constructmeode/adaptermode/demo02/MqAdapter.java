package com.lsy.constructmeode.adaptermode.demo02;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 适配消息 公共的消息
 * <p>
 * 将用户的属性 映射 成我们需要的属性
 *
 * @author TT
 */
public class MqAdapter {
    /**
     * 消息映射处理
     *
     * @param strJson 消息
     * @param link    Map映射
     * @return 处理后的通用消息
     * @throws NoSuchMethodException     没有这样的方法异常
     * @throws InvocationTargetException 调用目标异常
     * @throws IllegalAccessException    非法访问异常
     */
    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    /**
     * 消息映射处理
     *
     * @param obj  map
     * @param link Map连接
     * @return 处理后的通用消息
     * @throws NoSuchMethodException     没有这样的方法异常
     * @throws InvocationTargetException 调用目标异常
     * @throws IllegalAccessException    非法访问异常
     */
    public static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        // 便利link的Value，为rebateInfo赋值
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            RebateInfo.class
                    .getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class)
                    .invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }

}
