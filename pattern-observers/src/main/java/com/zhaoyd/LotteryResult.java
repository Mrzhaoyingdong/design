package com.zhaoyd;

import java.util.Date;

/**
 *  @Description: 模拟摇号信息
 *  @author: zhao_yd
 *  @Date: 2021/8/25 11:26 上午
 *
 */

public class LotteryResult {

    private String uId;
    private String msg;
    private Date dateTime;

    public LotteryResult(String uId, String msg, Date dateTime) {
        this.uId = uId;
        this.msg = msg;
        this.dateTime = dateTime;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
