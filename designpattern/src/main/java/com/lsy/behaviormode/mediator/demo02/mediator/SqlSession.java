package com.lsy.behaviormode.mediator.demo02.mediator;

import java.util.List;

/**
 * 数据库操作的查询接口
 */
public interface SqlSession {
    /**
     * 查询一个
     */
    <T> T selectOne(String statement);

    /**
     * 查询一个
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 查询多个
     */
    <T> List<T> selectList(String statement);

    /**
     * 查询多个
     */
    <T> List<T> selectList(String statement, Object parameter);

    void close();
}
