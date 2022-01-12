package com.zhaoyd6.patternface.door;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  抽象工厂类
 *  抽象工厂模式与工厂方法模式虽然主要
 *  是为了解决接口选择问题，但在实现上
 *  抽象工厂是一个中心工厂，创建其他工厂的模式
 *
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/8/26 4:33 下午
 *
 */



public interface CacheService {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
