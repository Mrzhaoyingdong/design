package com.zhaoyd6.patternface.door.channel;

import com.zhaoyd6.patternface.door.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 桥接模式
 *
 * 桥接模式的主要作用就是
 * 通过将抽象部分与实现分离
 * 把多种可匹配的使用进行组合
 *
 *
 *
 *  @Description: 抽象类 Pay
 *  @author: zhao_yd
 *  @Date: 2021/7/28 4:49 下午
 *
 */


public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    protected IPayMode payMode;

    public Pay(IPayMode payMode){
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
