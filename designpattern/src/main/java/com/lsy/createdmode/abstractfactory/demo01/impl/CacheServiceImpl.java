package com.lsy.createdmode.abstractfactory.demo01.impl;

import com.lsy.createdmode.abstractfactory.demo00.matter.RedisSingle;
import com.lsy.createdmode.abstractfactory.demo00.matter.EgmCluster;
import com.lsy.createdmode.abstractfactory.demo00.matter.IirRedisCluster;
import com.lsy.createdmode.abstractfactory.demo01.CacheService;

import java.util.concurrent.TimeUnit;

/**
 * @author TT
 */
public class CacheServiceImpl implements CacheService {

    /**
     * IIR集群标识码
     */
    private final int IIR_CLUSTER_CODE = 1;
    /**
     * EMG集群标识码
     */
    private final int EGM_CLUSTER_CODE = 2;
    /**
     * 模拟注入Iir集群
     */
    private final IirRedisCluster iirServer = new IirRedisCluster();
    /**
     * 模拟注入Egm集群
     */
    private final EgmCluster egmServer = new EgmCluster();
    /**
     * 模拟注入单机
     */
    private final RedisSingle redisUtils = new RedisSingle();


    @Override
    public String get(String key, int redisType) {
        if (IIR_CLUSTER_CODE == redisType) {
            return iirServer.get(key);
        } else if (EGM_CLUSTER_CODE == redisType) {
            return egmServer.gain(key);
        } else {
            return redisUtils.get(key);
        }
    }

    @Override
    public void set(String key, String value, int redisType) {
        if (IIR_CLUSTER_CODE == redisType) {
            iirServer.set(key, value);
        } else if (EGM_CLUSTER_CODE == redisType) {
            egmServer.set(key, value);
        } else {
            redisUtils.set(key, value);
        }

    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        if (IIR_CLUSTER_CODE == redisType) {
            iirServer.setExpire(key, value, timeout, timeUnit);
        } else if (EGM_CLUSTER_CODE == redisType) {
            egmServer.setEx(key, value, timeout, timeUnit);
        } else {
            redisUtils.set(key, value, timeout, timeUnit);
        }
    }

    @Override
    public void del(String key, int redisType) {
        if (IIR_CLUSTER_CODE == redisType) {
            iirServer.del(key);
        } else if (EGM_CLUSTER_CODE == redisType) {
            egmServer.delete(key);
        } else {
            redisUtils.del(key);
        }
    }

    @Override
    public void findAll(int redisType) {
        if (IIR_CLUSTER_CODE == redisType) {
            iirServer.findAll();
        } else if (EGM_CLUSTER_CODE == redisType) {
            egmServer.findAll();
        } else {
            redisUtils.findAll();
        }
    }
}
