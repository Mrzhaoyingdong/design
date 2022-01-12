package com.zhaoyd.user.impl;

import com.zhaoyd.user.User;
import com.zhaoyd.visitor.Visitor;

import java.math.BigDecimal;


/**
 *  @Description: 老师
 *  @author: zhao_yd
 *  @Date: 2021/8/26 1:36 下午
 *
 */

public class Teacher extends User {


    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 升本率
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
