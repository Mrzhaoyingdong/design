package com.zhaoyd;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description: 单元测试
 *  @author: zhao_yd
 *  @Date: 2021/8/25 2:11 下午
 *
 */

public class APITest {

    private Logger logger = LoggerFactory.getLogger(APITest.class);

    @Test
    public void test() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("27657x9109zzd876");
        logger.info("测试结果{}", JSON.toJSONString(result));
    }
}
