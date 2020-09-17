package com.lsy.behaviormode.mediator.demo02.dao;

import com.lsy.behaviormode.mediator.demo02.po.School;

/**
 * 操作数据库接口
 *
 * @author TT
 */
public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
