package com.lsy.constructmode.proxy.demo02;


import com.lsy.constructmode.proxy.demo02.myannotation.Select;

public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}
