package com.zhaoyd6.patternface.door;

import com.zhaoyd6.patternface.door.store.ICommodity;
import com.zhaoyd6.patternface.door.store.impl.CardCommodityService;
import com.zhaoyd6.patternface.door.store.impl.CouponCommodityService;
import com.zhaoyd6.patternface.door.store.impl.GoodsCommodityService;
/**
 * <p>
 * 工厂模式
 * 工厂模式又称为工厂方法模式，是一种创建型设计模式
 * 其在父类中提供一个创建对象的方法，允许子类决定
 * 实例化对象的类型。
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/8/26 3:55 下午
 *
 */

public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品类型");
    }

}
