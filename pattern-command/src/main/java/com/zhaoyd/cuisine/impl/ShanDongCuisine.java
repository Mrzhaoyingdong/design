package com.zhaoyd.cuisine.impl;


import com.zhaoyd.cook.ICook;
import com.zhaoyd.cuisine.ICuisine;

/**
 *  @Description: 山东（鲁菜）
 *  @author: zhao_yd
 *  @Date: 2021/8/11 2:30 下午
 *
 */

public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}