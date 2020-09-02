package com.lsy.abstractfactory.demo02.factory;

import java.util.concurrent.TimeUnit;

/**
 * 适配器接口
 *
 * @author TT
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
