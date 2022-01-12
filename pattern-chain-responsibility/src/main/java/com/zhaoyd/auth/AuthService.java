package com.zhaoyd.auth;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 责任链设计模式
 * <p>
 *
 * 责任链模式的核心是解决一组服务中的先后
 * 执行处理关系
 *
 *
 *  @Description: 模拟审核流程
 *
 *  1、aith          审核流程
 *  2、queryAuthInfo 查询审核信息(时间)
 *
 *  @author: zhao_yd
 *  @Date: 2021/8/6 4:39 下午
 *
 */

public class AuthService {

    private static Map<String, Date>  authMap = new ConcurrentHashMap<>();

    public static Date queryAuthInfo(String uId,String orderId){
        return authMap.get(uId.concat(orderId));
    }

    public static void auth(String uId,String orderId){
        authMap.put(uId.concat(orderId),new Date());
    }

}
