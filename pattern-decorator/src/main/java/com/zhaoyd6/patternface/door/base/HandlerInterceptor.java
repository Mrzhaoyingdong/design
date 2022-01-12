package com.zhaoyd6.patternface.door.base;
/**
 *  @Description: 装饰者模式
 *  @author: zhao_yd
 *  @Date: 2021/8/3 10:03 上午
 *
 */

public interface HandlerInterceptor {

    boolean preHandle(String request,String response,Object handler);
}
