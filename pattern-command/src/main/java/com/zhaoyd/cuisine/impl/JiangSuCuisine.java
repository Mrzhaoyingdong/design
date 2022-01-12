package com.zhaoyd.cuisine.impl;

import com.zhaoyd.cook.ICook;
import com.zhaoyd.cuisine.ICuisine;

/**
 *  @Description: 江苏（苏菜）
 *  @author: zhao_yd
 *  @Date: 2021/8/11 2:31 下午
 *
 */

public class JiangSuCuisine implements ICuisine {

    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}