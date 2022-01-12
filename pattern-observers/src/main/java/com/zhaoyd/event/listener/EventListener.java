package com.zhaoyd.event.listener;

import com.zhaoyd.LotteryResult;

/**
 *
 *
 *  @Description: 事件监听接口定义
 *  @author: zhao_yd
 *  @Date: 2021/8/25 11:24 上午
 *
 */

public interface EventListener {

    void doEvent(LotteryResult lotteryResult);
}
