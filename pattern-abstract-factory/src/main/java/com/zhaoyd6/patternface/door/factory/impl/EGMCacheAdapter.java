package com.zhaoyd6.patternface.door.factory.impl;

import com.zhaoyd6.patternface.door.factory.ICacheAdapter;
import com.zhaoyd6.patternface.door.factory.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 *  @Description: EGM缓存操作类
 *  @author: zhao_yd
 *  @Date: 2021/7/2 5:18 下午
 *
 */

public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key,value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
