package com.zhaoyd.visitor.impl;

import com.zhaoyd.user.impl.Student;
import com.zhaoyd.user.impl.Teacher;
import com.zhaoyd.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parent implements Visitor {

    Logger logger = LoggerFactory.getLogger(Parent.class);

    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{} 班级：{} 排名：{}", student.name, student.clazz, student.ranking());
    }

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{} 班级：{} 级别：{}", teacher.name, teacher.clazz, teacher.identity);
    }
}
