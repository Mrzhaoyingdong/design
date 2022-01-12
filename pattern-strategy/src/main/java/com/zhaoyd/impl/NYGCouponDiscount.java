package com.zhaoyd.impl;

import com.zhaoyd.ICouponDiscount;

import java.math.BigDecimal;

/**
 *  @Description: n元购买
 *  @author: zhao_yd
 *  @Date: 2021/8/25 5:32 下午
 *
 */


public class NYGCouponDiscount implements ICouponDiscount<Double> {

    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
