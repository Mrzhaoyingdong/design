package com.zhaoyd6.patternface.door.channel;

import com.zhaoyd6.patternface.door.mode.IPayMode;

import java.math.BigDecimal;

/**
 *  @Description: 微信支付
 *  @author: zhao_yd
 *  @Date: 2021/7/28 4:57 下午
 *
 */

public class WxPay extends Pay{

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟微信渠道支付划账开始.uId：{},tradeId:{},amount:{}",uId,tradeId,amount);
        boolean security = payMode.security(uId);
        logger.info("模拟微信渠道支付风控校验.uId:{},tradeId:{}, security:{}",uId,tradeId,security);

        if(!security){
            logger.info("模拟微信渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("模拟微信渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }
}
