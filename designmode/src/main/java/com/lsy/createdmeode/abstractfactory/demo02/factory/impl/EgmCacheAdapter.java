package com.lsy.createdmeode.abstractfactory.demo02.factory.impl;


import com.lsy.createdmeode.abstractfactory.demo00.matter.EgmCluster;
import com.lsy.createdmeode.abstractfactory.demo02.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author TT
 */
public class EgmCacheAdapter implements ICacheAdapter {

    private EgmCluster egm = new EgmCluster();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
