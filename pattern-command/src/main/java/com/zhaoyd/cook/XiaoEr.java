package com.zhaoyd.cook;

import com.zhaoyd.cuisine.ICuisine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Description: 店小二负责点单
 *  @author: zhao_yd
 *  @Date: 2021/8/11 3:16 下午
 *
 */

public class XiaoEr {

    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);
    private List<ICuisine> cuisineList  = new ArrayList<>();

    public void order(ICuisine cuisine){
        cuisineList.add(cuisine);
    }

    //点单
    public synchronized void placeOrder(){
        for(ICuisine cuisine: cuisineList){
            cuisine.cook();
        }
    }

}
