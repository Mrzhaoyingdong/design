package com.zhaoyd6.patternface.web;


import com.alibaba.fastjson.JSONObject;
import com.zhaoyd6.patternface.door.DoJoinPoint;
import com.zhaoyd6.patternface.door.annotation.DoDoor;
import com.zhaoyd6.patternface.domain.UserInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *  @Description: 外观设计模式
 *  @author: zhao_yd
 *  @Date: 2021/8/4 3:30 下午
 *
 */

@RestController
public class HelloWorldController implements ApplicationContextAware {

    @Value("${server.port}")
    private int port;

    private static ApplicationContext applicationContext;

    /**
     * @DoDoor 自定义注解
     * key：需要从入参取值的属性字段，如果是对象则从对象中取值，如果是单个值则直接使用
     * returnJson：预设拦截时返回值，是返回对象的Json
     *
     * http://localhost:8080/api/queryUserInfo?userId=1001
     * http://localhost:8080/api/queryUserInfo?userId=小团团
     */
    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId) {

        DoJoinPoint bean = applicationContext.getBean(DoJoinPoint.class);
        System.out.println(JSONObject.toJSONString(bean));

        return new UserInfo("虫虫:" + userId, 19, "天津市南开区旮旯胡同100号");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
