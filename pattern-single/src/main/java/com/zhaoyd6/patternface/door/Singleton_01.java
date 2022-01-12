package com.zhaoyd6.patternface.door;
/**
 *  @Description: 懒汉模式(线程不安全)
 *  @author: zhao_yd
 *  @Date: 2021/7/23 5:07 下午
 *
 */

public class Singleton_01 {

    private static Singleton_01 singleton_01;

    private Singleton_01(){

    }

    public Singleton_01 getInstance(){
        if(null != singleton_01){
            return singleton_01;
        }

        singleton_01 = new Singleton_01();
        return singleton_01;
    }



}
