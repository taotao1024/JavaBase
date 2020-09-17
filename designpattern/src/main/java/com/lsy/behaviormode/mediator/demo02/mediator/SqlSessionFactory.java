package com.lsy.behaviormode.mediator.demo02.mediator;

/**
 * SqlSession工厂
 */
public interface SqlSessionFactory {
    /**
     * 开启一个SqlSession
     *
     * @return SqlSession
     */
    SqlSession openSession();

}
