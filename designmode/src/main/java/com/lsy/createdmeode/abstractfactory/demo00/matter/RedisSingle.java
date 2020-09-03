package com.lsy.createdmeode.abstractfactory.demo00.matter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具
 *
 * @author TT
 */
public class RedisSingle {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(RedisSingle.class);
    /**
     * 数据仓库
     */
    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    /**
     * 查询
     *
     * @param key key
     * @return result
     */
    public String get(String key) {
        logger.info("Redis获取数据 key：{}", key);
        return dataMap.get(key);
    }

    /**
     * 添加
     *
     * @param key   key
     * @param value value
     */
    public void set(String key, String value) {
        logger.info("Redis写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    /**
     * 超时添加（未实现）
     *
     * @param key      key
     * @param value    value
     * @param timeout  超时时间
     * @param timeUnit 时间单位
     */
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("Redis写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    /**
     * 删除
     *
     * @param key key
     */
    public void del(String key) {
        logger.info("Redis删除数据 key：{}", key);
        dataMap.remove(key);
    }

    /**
     * 查询全部数据
     */
    public void findAll() {
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

}
