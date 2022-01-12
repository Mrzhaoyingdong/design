package com.zhaoyd;

import com.zhaoyd.event.EventManager;
import com.zhaoyd.event.listener.MQEventListener;
import com.zhaoyd.event.listener.MessageEventListener;

/**
 *  @Description: 抽象类
 *  @author: zhao_yd
 *  @Date: 2021/8/25 2:03 下午
 *
 */

public abstract class LotteryService {

    private EventManager eventManager;


    public LotteryService(){
        eventManager = new EventManager(EventManager.EventType.Message,EventManager.EventType.MQ);
        eventManager.subscribe(EventManager.EventType.MQ,new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message,new MessageEventListener());
    }

    /**
     * 摇号的时候用子类实现，然后发布事件通知
     *
     * @param uId
     * @return
     */
    public LotteryResult draw(String uId){
        LotteryResult lotteryResult = doDraw(uId);
        // 需要什么通知就给调用什么方法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);
}
