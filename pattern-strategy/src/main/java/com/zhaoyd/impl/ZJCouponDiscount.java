package com.zhaoyd.impl;

import com.zhaoyd.ICouponDiscount;

import java.math.BigDecimal;

/**
 *  @Description: 直减
 *  @author: zhao_yd
 *  @Date: 2021/8/25 5:33 下午
 *
 */


public class ZJCouponDiscount implements ICouponDiscount<Double> {


    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {

        BigDecimal subtract = skuPrice.subtract(new BigDecimal(couponInfo));
        if(subtract.compareTo(BigDecimal.ZERO) < 0){
            return BigDecimal.ONE;
        }
        return subtract;
    }
}
