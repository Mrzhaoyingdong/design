package com.zhaoyd.auth.link;
/**
 *  @Description: 审批信息
 *  @author: zhao_yd
 *  @Date: 2021/8/6 4:50 下午
 *
 */

public class AuthInfo {

    private String code;
    private String info = "";


    public AuthInfo(String code,String ...infos){
        this.code = code;
        for(String str:infos){
            this.info = info.concat(str);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
