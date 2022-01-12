package com.zhaoyd.user;

import com.zhaoyd.visitor.Visitor;

/**
 *  @Description: 用户基本信息抽象类
 *  @author: zhao_yd
 *  @Date: 2021/8/26 1:29 下午
 *
 */

public abstract class User {

    public String name;     //姓名
    public String identity; // 身份：重点班、普通班 | 特级教师、普通教师、实习教师
    public String clazz;   //班级

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    //核心访问方法
    public abstract void accept(Visitor visitor);

}
