package com.zhaoyd6.patternface.door;
/**
 *
 *  @Description: 内部类
 *  @author: zhao_yd
 *  @Date: 2021/7/23 5:16 下午
 *
 */

public class Singleton_04 {

    private static class SingletonHolder{
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04(){

    }

    public static Singleton_04 getInstance(){
        return SingletonHolder.instance;
    }
}
