package com.lsy.abstractfactory.demo01.impl;

import com.lsy.abstractfactory.demo01.CacheService;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


public class CacheServiceImplTest {

    /**
     * 模拟注入
     */
    CacheService cacheService = new CacheServiceImpl();

    @Test(timeout = 1000)
    public void get() {
        cacheService.get("user_name_01", 1);
        cacheService.get("user_name_02", 2);
        cacheService.get("user_name_06", -1);
    }

    @Test(timeout = 1000)
    public void set() {
        cacheService.set("user_name_01", "小傅哥", 1);
        cacheService.set("user_name_02", "小傅哥", 2);
        cacheService.set("user_name_03", "小傅哥", 3);
    }

    @Test(timeout = 1000)
    public void testSet() {
        cacheService.set("user_name_04", "小帅哥", 20L,TimeUnit.SECONDS,1);
        cacheService.set("user_name_05", "小帅哥", 20L,TimeUnit.SECONDS,2);
        cacheService.set("user_name_06", "小帅哥", 20L,TimeUnit.SECONDS,3);
    }

    @Test(timeout = 1000)
    public void del() {
        this.testSet();
        cacheService.del("user_name_04",1);
        cacheService.del("user_name_05",1);
        cacheService.del("user_name_06",1);
    }

    @Test(timeout = 1000)
    public void findAll() {
        this.set();
        this.testSet();
        cacheService.findAll(1);
        cacheService.findAll(2);
        cacheService.findAll(-1);
    }
}