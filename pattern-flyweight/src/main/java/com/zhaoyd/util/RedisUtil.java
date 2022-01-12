package com.zhaoyd.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  @Description: 模拟redis工具类
 *  @author: zhao_yd
 *  @Date: 2021/8/5 8:09 下午
 *
 */


public class RedisUtil {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private AtomicInteger stock = new AtomicInteger(0);

    public RedisUtil() {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            // 模拟库存消耗
            stock.addAndGet(1);
        }, 0, 100000, TimeUnit.MICROSECONDS);
    }

    public int getStockUsed(){
        return stock.get();
    }

}
