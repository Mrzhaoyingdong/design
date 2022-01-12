package com.zhaoyd.agent;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *  @Description: 自定义FactoryBean
 *  @author: zhao_yd
 *  @Date: 2021/8/6 1:55 下午
 *
 */

public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Logger log = LoggerFactory.getLogger(MapperFactoryBean.class);

    public Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface){
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler invocationHandler = ((proxy, method, args) -> {
            Select annotation = method.getAnnotation(Select.class);
            log.info("SQL :{}",annotation.value().replace("#{userId}",args[0].toString()));
            return args[0];
        });
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{mapperInterface},invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton(){
        return true;
    }
}
