package com.zhaoyd.cook.impl;

import com.zhaoyd.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description: 四川厨师
 *  @author: zhao_yd
 *  @Date: 2021/8/11 2:24 下午
 *
 */

public class SiChuanCook  implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    @Override
    public void doCooking() {
        logger.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
    }
}
