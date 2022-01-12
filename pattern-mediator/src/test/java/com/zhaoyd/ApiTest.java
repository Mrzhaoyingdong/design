package com.zhaoyd;

import com.alibaba.fastjson.JSON;
import com.zhaoyd.mediator.Resources;
import com.zhaoyd.mediator.SqlSession;
import com.zhaoyd.mediator.SqlSessionFactory;
import com.zhaoyd.mediator.SqlSessionFactoryBuilder;
import com.zhaoyd.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);


    @Test
    public void test_queryUserInfoById() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User user = session.selectOne("com.zhaoyd.dao.IUserDao.queryUserInfoById", 1L);
                logger.info("测试结果：{}", JSON.toJSONString(user));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
