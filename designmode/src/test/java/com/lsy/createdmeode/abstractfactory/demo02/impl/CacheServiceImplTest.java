package com.lsy.createdmeode.abstractfactory.demo02.impl;

import com.lsy.createdmeode.abstractfactory.demo02.CacheService;
import com.lsy.createdmeode.abstractfactory.demo02.factory.JdkProxy;
import com.lsy.createdmeode.abstractfactory.demo02.factory.impl.EgmCacheAdapter;
import com.lsy.createdmeode.abstractfactory.demo02.factory.impl.IirCacheAdapter;
import org.junit.Test;

public class CacheServiceImplTest {
    @Test
    public void test_CacheService() throws Exception {

        CacheService proxy_EGM = JdkProxy.getProxy(CacheServiceImpl.class, new EgmCacheAdapter());
        proxy_EGM.set("user_name_01", "小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果：" + val01);

        CacheService proxy_IIR = JdkProxy.getProxy(CacheServiceImpl.class, new IirCacheAdapter());
        proxy_IIR.set("user_name_01", "小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val02);

    }
}