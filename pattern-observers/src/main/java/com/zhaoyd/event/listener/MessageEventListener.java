package com.zhaoyd.event.listener;

import com.zhaoyd.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description: 短信事件监听
 *  @author: zhao_yd
 *  @Date: 2021/8/25 11:28 上午
 *
 */

public class MessageEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);


    @Override
    public void doEvent(LotteryResult lotteryResult) {
        logger.info("给用户 {} 发短信通知（短信）：{}",lotteryResult.getuId(),lotteryResult.getMsg());
    }

}
