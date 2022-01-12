package com.zhaoyd6.patternface.door.factory.matter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
/**
 *  @Description: 模拟 EGM集群
 *  @author: zhao_yd
 *  @Date: 2021/7/2 4:51 下午
 *
 */

public class EGM {

    private Logger logger = LoggerFactory.getLogger(EGM.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    public String gain(String key) {
        logger.info("EGM获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("EGM写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("EGM写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void delete(String key) {
        logger.info("EGM删除数据 key：{}", key);
        dataMap.remove(key);
    }
}
