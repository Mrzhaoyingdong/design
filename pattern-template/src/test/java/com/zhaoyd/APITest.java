package com.zhaoyd;

import com.zhaoyd.impl.DangDangNetMall;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description:  单元测试
 *  @author: zhao_yd
 *  @Date: 2021/8/26 11:10 上午
 *
 */

public class APITest {

    public Logger logger = LoggerFactory.getLogger(APITest.class);

    /**
     * 测试链接
     * 京东；https://item.jd.com/100008348542.html
     * 淘宝；https://detail.tmall.com/item.htm
     * 当当；http://product.dangdang.com/1509704171.html
     */
    @Test
    public void test_NetMall() {
        NetMall netMall = new DangDangNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("http://product.dangdang.com/1509704171.html");
        logger.info("测试结果：{}", base64);
    }

}
