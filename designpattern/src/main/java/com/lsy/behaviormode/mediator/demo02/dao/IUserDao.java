package com.lsy.behaviormode.mediator.demo02.dao;

import com.lsy.behaviormode.mediator.demo02.po.User;

/**
 * 操作数据库接口
 *
 * @author TT
 */
public interface IUserDao {

    User queryUserInfoById(Long id);

}
