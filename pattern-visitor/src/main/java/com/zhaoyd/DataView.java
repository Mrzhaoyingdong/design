package com.zhaoyd;

import com.zhaoyd.user.User;
import com.zhaoyd.user.impl.Student;
import com.zhaoyd.user.impl.Teacher;
import com.zhaoyd.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Description: 数据看板
 *  @author: zhao_yd
 *  @Date: 2021/8/26 2:06 下午
 *
 *  <p>
 *   访问者设计模式
 *   访问者设计模式要解决的核心事项是，在一个稳定的数据结构下
 *   例如用户信息、雇员信息等，增加易变的业务访问逻辑，为了增强扩展性，
 *   将这两部分的业务解耦的一种设计模式
 *
 *
 */

public class DataView {

    List<User> userList = new ArrayList<User>();

    public DataView() {
        userList.add(new Student("谢飞机", "重点班", "一年一班"));
        userList.add(new Student("windy", "重点班", "一年一班"));
        userList.add(new Student("大毛", "普通班", "二年三班"));
        userList.add(new Student("Shing", "普通班", "三年四班"));
        userList.add(new Teacher("BK", "特级教师", "一年一班"));
        userList.add(new Teacher("娜娜Goddess", "特级教师", "一年一班"));
        userList.add(new Teacher("dangdang", "普通教师", "二年三班"));
        userList.add(new Teacher("泽东", "实习教师", "三年四班"));
    }

    // 展示
    public void show(Visitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }

}
