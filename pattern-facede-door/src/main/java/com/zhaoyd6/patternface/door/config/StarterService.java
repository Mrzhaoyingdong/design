package com.zhaoyd6.patternface.door.config;
/**
 *  @Description: 切面定义
 *  @author: zhao_yd
 *  @Date: 2021/8/4 10:10 上午
 *
 */

public class StarterService {

    private String userStr;

    public StarterService(String userStr){
        this.userStr = userStr;
    }

    public String[] split(String separatorChar){
        return this.userStr.split(separatorChar);
    }
}
