package com.zhaoyd;

import java.math.BigDecimal;

/**
 *
 * 策略模式
 * 策略设计模式是一种行为模式，它能所解决的场景是
 * 一般是具有同类可替代的行为逻辑算法场景。
 * 比如：
 * 不同类型的交易方式（信用卡、支付宝、微信）、生成唯一ID策略
 * （UUID、DB自增、DB+redis、雪花算法、Leaf算法）等，都可以使用
 * 策略模式进行行为包装，供给外部使用
 *
 *
 *  @Description: 优惠券折扣计算接口
 *
 *  @author: zhao_yd
 *  @Date: 2021/8/25 5:22 下午
 *
 *  <p>
 *   优惠券类型；
 *   1. 直减券
 *   2. 满减券
 *   3. 折扣券
 *   4. n元购
 */

public interface ICouponDiscount<T> {

    /**
     * 优惠券金额计算
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param skuPrice   sku金额
     * @return           优惠后金额
     */
    BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice);
}
