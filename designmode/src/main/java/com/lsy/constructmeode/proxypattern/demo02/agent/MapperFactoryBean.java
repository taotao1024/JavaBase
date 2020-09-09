package com.lsy.constructmeode.proxypattern.demo02.agent;

import com.lsy.constructmeode.proxypattern.demo02.myannotation.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理类定义
 *
 * @param <T>
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Logger logger = LoggerFactory.getLogger(MapperFactoryBean.class);

    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        // 代理类
        InvocationHandler handler = (proxy, method, args) -> {
            // 获取注解信息
            Select select = method.getAnnotation(Select.class);
            logger.info("SQL：{}", select.value().replace("#{uId}", args[0].toString()));
            return args[0] + "";
        };
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
