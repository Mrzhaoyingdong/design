package com.zhaoyd.user.impl;

import com.zhaoyd.user.User;
import com.zhaoyd.visitor.Visitor;

/**
 *  @Description: 学生
 *  @author: zhao_yd
 *  @Date: 2021/8/26 1:33 下午
 *
 */

public class Student extends User {


    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }
}
