package com.zhaoyd;

import java.math.BigDecimal;

public class Context<T> {


    private ICouponDiscount<T> iCouponDiscount;

    public Context(ICouponDiscount<T> iCouponDiscount) {
        this.iCouponDiscount = iCouponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice){
        return iCouponDiscount.discountAmount(couponInfo,skuPrice);
    }
}
