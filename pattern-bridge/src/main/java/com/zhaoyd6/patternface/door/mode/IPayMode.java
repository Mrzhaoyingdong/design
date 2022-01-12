package com.zhaoyd6.patternface.door.mode;
/**
 *  @Description: 支付方式接口
 *  @author: zhao_yd
 *  @Date: 2021/7/28 4:50 下午
 *
 */

public interface IPayMode {

    boolean security(String uId);
}
