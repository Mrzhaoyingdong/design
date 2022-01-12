package com.zhaoyd6.patternface.door.impl;

import com.zhaoyd6.patternface.door.OrderAdapterService;
import com.zhaoyd6.patternface.door.service.POPOrderService;

/**
 *  接口适配
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/7/26 3:05 下午
 *
 */

public class POPOrderAdapterService implements OrderAdapterService {

    POPOrderService popOrderService = new POPOrderService();

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
