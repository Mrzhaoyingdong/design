package com.zhaoyd6.patternface.door.factory;

import com.zhaoyd6.patternface.door.factory.utils.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *  @Description: 通过JDK代理
 *  @author: zhao_yd
 *  @Date: 2021/7/2 5:25 下午
 *
 */

public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter){
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method me = ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args));
        Object invoke = me.invoke(cacheAdapter, args);
        return invoke;
    }
}
