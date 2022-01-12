package com.zhaoyd6.patternface.door;
/**
 *  @Description: 双重锁校验
 *  @author: zhao_yd
 *  @Date: 2021/7/23 5:33 下午
 *
 */

public class Singleton_05 {

    private static Singleton_05 instance;

    private Singleton_05(){}

    public static Singleton_05 getInstance(){
        if(null != instance){
            return instance;
        }

        synchronized (Singleton_05.class){
            if(null == instance){
                instance = new Singleton_05();
            }
        }
        return instance;
    }

}
