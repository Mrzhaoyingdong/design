package com.zhaoyd;

import com.zhaoyd.util.RedisUtil;
/**
 *  @Description: 模拟controller
 *  @author: zhao_yd
 *  @Date: 2021/8/5 8:20 下午
 *
 */

public class ActivityController {

    private RedisUtil redisUtils = new RedisUtil();

    public Activity get(Long id){
        Activity activity = ActivityFactory.getActivity(id);
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }
}
