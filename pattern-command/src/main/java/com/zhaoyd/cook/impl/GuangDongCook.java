package com.zhaoyd.cook.impl;


import com.zhaoyd.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description: 广东厨师
 *  @author: zhao_yd
 *  @Date: 2021/8/11 2:26 下午
 *
 */

public class GuangDongCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("广东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
    }

}
