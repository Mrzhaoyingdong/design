package com.zhaoyd6.patternface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;



/**
 * <p>
 * 门面模式(外观模式)
 *
 * 外观模式也叫门面模式，主要解决的是降低
 * 调用方的使用接口的复杂逻辑组合。这样调用
 * 方与实际的接口提供方提供一个中间层，用于
 * 包装逻辑提供API接口，有时候外观模式也被
 * 用在中间件层，对服务中的通用性复杂逻辑进行中间层包装
 * 让使用方可以只关心业务开发
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/8/26 3:58 下午
 *
 */


@Configuration
@SpringBootApplication
public class PatternFaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatternFaceApplication.class, args);
    }

}
