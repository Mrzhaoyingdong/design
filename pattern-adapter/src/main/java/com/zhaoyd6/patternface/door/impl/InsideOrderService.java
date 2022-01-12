package com.zhaoyd6.patternface.door.impl;

import com.zhaoyd6.patternface.door.OrderAdapterService;
import com.zhaoyd6.patternface.door.service.OrderService;

public class InsideOrderService implements OrderAdapterService {

    OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        long result = orderService.queryUserOrderCount(uId);
        return result<=1;
    }
}
