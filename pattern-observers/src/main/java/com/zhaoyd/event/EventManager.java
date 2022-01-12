package com.zhaoyd.event;

import com.zhaoyd.LotteryResult;
import com.zhaoyd.event.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  @Description: 事件管理器
 *  @author: zhao_yd
 *  @Date: 2021/8/25 1:37 下午
 *
 */

public class EventManager {

    Map<Enum<EventType>, List<EventListener>> listenerMap = new HashMap<>();

    public EventManager(Enum<EventType>... operations){
        for(Enum<EventType> eventTypeEnum : operations){
            this.listenerMap.put(eventTypeEnum,new ArrayList<>());
        }
    }

    public enum EventType{
        MQ,Message;
    }

    /**
     * 订阅
     *
     * @param eventType     事件类型
     * @param eventListener 监听器
     */
    public void subscribe(Enum<EventType> eventType,EventListener eventListener){
        List<EventListener> eventListeners = listenerMap.get(eventType);
        eventListeners.add(eventListener);
    }


    /**
     * 取消订阅
     *
     * @param eventType
     * @param eventListener
     */
    public void unsubscribe(Enum<EventType> eventType,EventListener eventListener){
        List<EventListener> eventListeners = listenerMap.get(eventType);
        eventListeners.remove(eventListener);
    }


    /**
     * 通知
     *
     * @param eventType 事件类型
     * @param result   结果
     */
    public void notify(Enum<EventType> eventType, LotteryResult result){
        List<EventListener> eventListeners = listenerMap.get(eventType);
        for(EventListener listener:eventListeners){
            listener.doEvent(result);
        }
    }

}
