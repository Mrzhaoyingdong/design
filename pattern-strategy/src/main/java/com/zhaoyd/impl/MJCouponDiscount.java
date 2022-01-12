package com.zhaoyd.impl;

import com.zhaoyd.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 *  @Description: 满减
 *  @author: zhao_yd
 *  @Date: 2021/8/25 5:25 下午
 *
 */

public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {

    /**
     * 满减计算
     * 1. 判断满足x元后-n元，否则不减
     * 2. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {

        String x = couponInfo.get("x");
        String n = couponInfo.get("n");

        //小于商品金额条件的，直接返回商品原价
        if(skuPrice.compareTo(new BigDecimal(x)) <0){
            return skuPrice;
        }

        //减去优惠金额判断
        BigDecimal subtract = skuPrice.subtract(new BigDecimal(n));
        if(skuPrice.compareTo(BigDecimal.ZERO) < 0){
            return BigDecimal.ONE;
        }
        return subtract;
    }
}
