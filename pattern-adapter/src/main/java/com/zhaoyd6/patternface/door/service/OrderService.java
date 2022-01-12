package com.zhaoyd6.patternface.door.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description:  适配器模式的主要作用就是把原本不兼容的接口，通过适配器修改做到统一
 *
 *  @author: zhao_yd
 *  @Date: 2021/7/26 2:04 下午
 *
 */


public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId){
        logger.info("自营商家，查询用户的订单是否为首单：{}", userId);
        return 10L;
    }

}
