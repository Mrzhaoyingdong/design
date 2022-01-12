package com.zhaoyd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 *  @Description: 定义执行顺序的抽象类
 *  @author: zhao_yd
 *  @Date: 2021/8/26 9:58 上午
 *
 *  <p>
 *   基础电商推广服务
 *   1. 生成最优价商品海报
 *   2. 海报含带推广邀请码
 *
 *  模版设计模式
 * 关于模版模式的核心点在于由抽象类定义抽象方法执行策略，
 * 也就是说父类规定了好一系列的执行标准，这些标准的串联成一整套的业务流程。
 *
 */


public abstract class NetMall {

    protected Logger logger = LoggerFactory.getLogger(NetMall.class);

    private String uId; //用户Id
    private String uPwd; //用户密码

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }


    /**
     * 生成商品推广海报
     *
     * @param skuUrl 商品地址(京东、淘宝、当当)
     * @return 海报图片base64位信息
     */
    public String generateGoodsPoster(String skuUrl){
        if(!login(uId,uPwd)) return null;
        Map<String, String> reptile = reptile(skuUrl);
        return createBase64(reptile);
    }


    //模拟登陆
    protected abstract Boolean login(String uId,String uPwd);

    //爬虫提取商品信息(登陆后的优惠价格)
    protected abstract Map<String,String> reptile(String skuUrl);

    //生成商品海报信息
    protected  abstract String createBase64(Map<String, String> goodsInfo);
}
