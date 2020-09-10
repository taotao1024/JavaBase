package com.lsy.createdmeode.abstractfactory.demo01;


import java.util.concurrent.TimeUnit;

/**
 * 缓存服务
 *
 * @author TT
 */
public interface CacheService {
    /**
     * 获取缓存
     *
     * @param key       key
     * @param redisType redisType
     * @return value
     */
    String get(final String key, int redisType);

    /**
     * 插入数据
     *
     * @param key       key
     * @param value     value
     * @param redisType redisType
     */
    void set(String key, String value, int redisType);

    /**
     * 超时插入数据
     *
     * @param key       key
     * @param value     value
     * @param timeout   超时时间
     * @param timeUnit  时间单位
     * @param redisType redisType
     */
    void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType);

    /**
     * 删除数据
     *
     * @param key       key
     * @param redisType redisType
     */
    void del(String key, int redisType);

    /**
     * 查询全部
     *
     * @param redisType redisType
     */
    void findAll(int redisType);

}
