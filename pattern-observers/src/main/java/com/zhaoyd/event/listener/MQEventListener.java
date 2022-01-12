package com.zhaoyd.event.listener;

import com.zhaoyd.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description: 模拟MQ监听
 *  @author: zhao_yd
 *  @Date: 2021/8/25 11:34 上午
 *
 */

public class MQEventListener implements EventListener{

    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult lotteryResult) {
        logger.info("记录用户{} 摇号结果(MQ) :{}",lotteryResult.getuId(),lotteryResult.getMsg());
    }
}
