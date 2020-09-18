package com.lsy.behaviormode.mediator.demo02.mediator.impl;


import com.lsy.behaviormode.mediator.demo02.mediator.Configuration;
import com.lsy.behaviormode.mediator.demo02.mediator.SqlSession;
import com.lsy.behaviormode.mediator.demo02.mediator.SqlSessionFactory;


/**
 *
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    /**
     * 通过构造方法向下传递Configuration配置文件
     *
     * @param configuration 配置文件
     */
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration.getConnection(), configuration.getMapperElement());
    }

}
