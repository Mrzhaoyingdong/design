package com.zhaoyd6.patternface.door;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 *
 * 适配模式
 * 适配器的主要作用就是把原本不兼容的接口，通过适配修改做到统一
 * 使得用户方便使用
 *
 *
 *
 *
 *  @Description: MQ适配器
 *  @author: zhao_yd
 *  @Date: 2021/7/26 3:10 下午
 *
 */

public class MQAdapter {

    public static RebateInfo filter(String strJson,Map<String,String> link) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return filter(JSON.parseObject(strJson,Map.class),link);
    }

    public static RebateInfo filter(Map obj,Map<String,String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for(String key:link.keySet()){
            Object val = obj.get(link.get(key));
            String upperCase = key.substring(0, 1).toUpperCase();
            String substring = key.substring(1);
            String result = "set" + upperCase + substring;
            Method method = RebateInfo.class.getMethod(result, String.class);
            method.invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }
}
