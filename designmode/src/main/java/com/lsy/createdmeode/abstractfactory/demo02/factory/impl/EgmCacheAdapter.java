package com.lsy.createdmeode.abstractfactory.demo02.factory.impl;


import com.lsy.createdmeode.abstractfactory.demo00.matter.EgmCluster;
import com.lsy.createdmeode.abstractfactory.demo02.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author TT
 */
public class EgmCacheAdapter implements ICacheAdapter {

    private EgmCluster egm = new EgmCluster();


    public String get(String key) {
        return egm.gain(key);
    }


    public void set(String key, String value) {
        egm.set(key, value);
    }


    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }


    public void del(String key) {
        egm.delete(key);
    }
}
