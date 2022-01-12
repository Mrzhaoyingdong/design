package com.zhaoyd6.patternface.door;
/**
 *  @Description: 饿汉模式（线程安全）
 *  @author: zhao_yd
 *  @Date: 2021/7/23 5:14 下午
 *
 */

public class Singleton_03 {
    //静态实例
    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03(){

    }

    public static Singleton_03 getInstance(){
        return instance;
    }

}
