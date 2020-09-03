package com.lsy.createdmeode.abstractfactory.demo02.factory;

import java.util.concurrent.TimeUnit;

/**
 * 适配器接口
 *
 * @author TT
 */
public interface ICacheAdapter {

    /**
     * 获取缓存
     *
     * @param key key
     * @return
     */
    String get(final String key);

    /**
     * 插入数据
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * 超时插入数据
     *
     * @param key      key
     * @param value    value
     * @param timeout  超时时间
     * @param timeUnit 时间单位
     */
    void set(String key, String value, long timeout, TimeUnit timeUnit);

    /**
     * 删除数据
     *
     * @param key key
     */
    void del(String key);

}
