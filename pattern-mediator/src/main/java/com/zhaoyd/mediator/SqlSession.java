package com.zhaoyd.mediator;

import java.util.List;

/**
 *  @Description: SqlSession接口
 *  @author: zhao_yd
 *  @Date: 2021/8/19 5:30 下午
 *
 */

public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement,Object parameter);

    void close();
}
