package com.zhaoyd.cuisine.impl;

import com.zhaoyd.cook.ICook;
import com.zhaoyd.cuisine.ICuisine;

/**
 *  @Description: 四川（川菜）
 *  @author: zhao_yd
 *  @Date: 2021/8/11 2:33 下午
 *
 */

public class SiChuanCuisine implements ICuisine {

    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}