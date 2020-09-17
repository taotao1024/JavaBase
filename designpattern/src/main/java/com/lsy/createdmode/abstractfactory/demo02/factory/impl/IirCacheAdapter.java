package com.lsy.createdmode.abstractfactory.demo02.factory.impl;


import com.lsy.createdmode.abstractfactory.demo00.matter.IirRedisCluster;
import com.lsy.createdmode.abstractfactory.demo02.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author TT
 */
public class IirCacheAdapter implements ICacheAdapter {

    private IirRedisCluster iir = new IirRedisCluster();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }

}
