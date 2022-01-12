package com.zhaoyd6.patternface.door;

import com.zhaoyd6.patternface.door.base.HandlerInterceptor;

/**
 * 装饰者模式
 * 不必改变原类文件和使用继承的情况下，动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象。
 *
 * 动态将职责附加到对象上，若要扩展功能，装饰者提供了比继承更具弹性的代替方案。
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/8/3 10:58 上午
 *
 */

public abstract class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;

    public SsoDecorator(){}

    public SsoDecorator(HandlerInterceptor handlerInterceptor){
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request,response,handler);
    }
}
