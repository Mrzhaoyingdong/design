package com.zhaoyd6.patternface.door;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 单例模式保证一个类只有一个实例，主要解决的问题是
 * 一个全局使用的类频繁的创建和消费。从而提升整体的代码性能
 *
 *
 *  @Description: 静态类使用
 *  @author: zhao_yd
 *  @Date: 2021/7/23 5:05 下午
 *
 */

public class Singleton_00 {

    /**
     * 静态Map
     */
    public static Map<String,String> cache = new ConcurrentHashMap<>();
}
