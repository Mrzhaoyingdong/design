package com.zhaoyd6.patternface.door.factory.impl;

import com.zhaoyd6.patternface.door.factory.ICacheAdapter;
import com.zhaoyd6.patternface.door.factory.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 *  @Description: IIR缓存操作
 *  @author: zhao_yd
 *  @Date: 2021/7/2 5:21 下午
 *
 */

public class IIRCacheAdapter implements ICacheAdapter {

    IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key,value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}
