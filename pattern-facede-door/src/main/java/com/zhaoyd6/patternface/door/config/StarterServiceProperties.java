package com.zhaoyd6.patternface.door.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *  @Description: 切面定义
 *  @author: zhao_yd
 *  @Date: 2021/8/4 10:12 上午
 *
 */
@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

}
