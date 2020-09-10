package com.lsy.createdmeode.abstractfactory.demo02.impl;


import com.lsy.createdmeode.abstractfactory.demo00.matter.RedisSingle;
import com.lsy.createdmeode.abstractfactory.demo02.CacheService;

import java.util.concurrent.TimeUnit;

/**
 * @author TT
 */
public class CacheServiceImpl implements CacheService {

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

}
