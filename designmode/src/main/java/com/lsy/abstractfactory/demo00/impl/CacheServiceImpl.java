package com.lsy.abstractfactory.demo00.impl;


import com.lsy.abstractfactory.demo00.CacheService;
import com.lsy.abstractfactory.demo00.matter.RedisSingle;

import java.util.concurrent.TimeUnit;

/**
 * 缓存操作
 *
 * @author TT
 */
public class CacheServiceImpl implements CacheService {
    /**
     * 模拟注入
     */
    private RedisSingle redisUtils = new RedisSingle();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }

    @Override
    public void findAll() {
        redisUtils.findAll();
    }

}
