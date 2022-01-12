package com.zhaoyd.mapper;

import com.zhaoyd.agent.Select;

public interface UserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);
}
