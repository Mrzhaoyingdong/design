package com.zhaoyd.impl;

import com.alibaba.fastjson.JSON;
import com.zhaoyd.HttpClient;
import com.zhaoyd.NetMall;
import sun.misc.BASE64Encoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  @Description: 当当网
 *  @author: zhao_yd
 *  @Date: 2021/8/26 11:04 上午
 *
 */

public class DangDangNetMall extends NetMall {


    public DangDangNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected Boolean login(String uId, String uPwd) {
        logger.info("模拟当当用户登录 uId：{} uPwd：{}", uId, uPwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String s = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher matcher = p9.matcher(s);
        Map<String,String> map = new ConcurrentHashMap<>();
        if(matcher.find()){
            map.put("name",matcher.group());
        }
        map.put("price", "4548.00");
        logger.info("模拟当当商品爬虫解析：{} | {} 元 {}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        logger.info("模拟生成当当商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }
}
