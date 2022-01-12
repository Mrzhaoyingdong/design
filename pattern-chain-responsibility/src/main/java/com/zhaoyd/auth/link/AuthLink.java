package com.zhaoyd.auth.link;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @Description:
 *
 *   审核规定：
 *   1. 601-610 三级审批 + 二级审批
 *   2. 611-620 三级审批 + 二级审批 + 一级审批
 *   3. 其他时间 三级审批
 *
 *  @author: zhao_yd
 *  @Date: 2021/8/6 4:52 下午
 *
 */

public abstract class AuthLink {

    protected Logger log = LoggerFactory.getLogger(AuthLink.class);

    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间格式化
    protected String levelUserId;  //级别人员Id
    protected String levelUserName; // 级别人员姓名
    private AuthLink next;

    public AuthLink(String levelUserId,String levelUserName){
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next(){
        return next;
    }

    public AuthLink appendNext(AuthLink next){
        this.next = next;
        return this;
    }

    /**
     * 审批抽象类
     *
     * @param uId
     * @param orderId
     * @param authDate
     * @return
     */
    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
