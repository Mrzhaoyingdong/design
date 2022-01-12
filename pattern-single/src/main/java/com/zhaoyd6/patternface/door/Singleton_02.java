package com.zhaoyd6.patternface.door;
/**
 *  @Description: 懒汉模式（线程安全）
 *  @author: zhao_yd
 *  @Date: 2021/7/23 5:10 下午
 *
 */

public class Singleton_02 {

    private static Singleton_02 singleton_02;

    private Singleton_02(){

    }

    public static synchronized Singleton_02 getInstance(){
        if(null != singleton_02){
            return singleton_02;
        }
        singleton_02 = new Singleton_02();
        return singleton_02;
    }
}
