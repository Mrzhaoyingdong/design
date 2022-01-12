package com.zhaoyd;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * 享元模式
 *
 * 说到享元模式，第一个想到的应该就是池技术了，String常量池、数据库连接池、
 * 缓冲池等等都是享元模式的应用，所以说享元模式是池技术的重要实现方式。
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/8/5 8:18 下午
 *
 */

public class ActivityFactory {

    static Map<Long, Activity> activityMap = new HashMap<Long, Activity>();

    public static Activity getActivity(Long id) {
        Activity activity = activityMap.get(id);
        if (null == activity) {
            // 模拟从实际业务应用从接口中获取活动信息
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("图书嗨乐");
            activity.setDesc("图书优惠券分享激励分享活动第二期");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }
        return activity;
    }

}
