package com.zhaoyd.visitor;

import com.zhaoyd.user.impl.Student;
import com.zhaoyd.user.impl.Teacher;

/**
 *  @Description: 访问者接口
 *  @author: zhao_yd
 *  @Date: 2021/8/26 1:34 下午
 *
 */

public interface Visitor {

    //访问学生信息
    void visit(Student student);

    //访问老师
    void visit(Teacher teacher);
}
