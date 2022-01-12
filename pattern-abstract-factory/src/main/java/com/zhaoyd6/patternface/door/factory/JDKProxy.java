package com.zhaoyd6.patternface.door.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter iCacheAdapter){
        //获取handler
        InvocationHandler handler = new JDKInvocationHandler(iCacheAdapter);
        //获取类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        Class<?>[] interfaces = interfaceClass.getInterfaces();
        Object o = Proxy.newProxyInstance(contextClassLoader, new Class[]{interfaces[0]}, handler);
        return (T)o;

    }
}
