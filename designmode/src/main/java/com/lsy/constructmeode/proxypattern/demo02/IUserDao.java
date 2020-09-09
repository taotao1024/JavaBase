package com.lsy.constructmeode.proxypattern.demo02;


import com.lsy.constructmeode.proxypattern.demo02.myannotation.Select;

public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}
