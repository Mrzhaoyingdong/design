package com.zhaoyd;

import com.zhaoyd.visitor.impl.Parent;
import com.zhaoyd.visitor.impl.Principal;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description: 单元测试
 *  @author: zhao_yd
 *  @Date: 2021/8/26 2:07 下午
 *
 */

public class APITest {


    Logger logger = LoggerFactory.getLogger(APITest.class);

    @Test
    public void test(){
        DataView dataView = new DataView();
        logger.info("\r\n家长视角访问：");
        dataView.show(new Parent());     // 家长

        logger.info("\r\n校长视角访问：");
        dataView.show(new Principal());  // 校长

    }
}
