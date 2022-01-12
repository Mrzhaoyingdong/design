package com.zhaoyd.mediator;
/**
 *  @Description: SqlSessionFactory 开启 session
 *  @author: zhao_yd
 *  @Date: 2021/8/19 5:33 下午
 *
 */

public interface SqlSessionFactory {

    SqlSession openSession();

}
