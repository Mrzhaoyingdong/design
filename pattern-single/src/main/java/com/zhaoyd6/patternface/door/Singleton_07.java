package com.zhaoyd6.patternface.door;
/**
 *  @Description:  枚举单例(线程安全)
 *  @author: zhao_yd
 *  @Date: 2021/7/26 11:20 上午
 *
 */

public enum  Singleton_07 {

    INSTANCE;
    public void test(){
        System.out.println("hi~~");
    }


    public static void main(String[] args) {
        Singleton_07.INSTANCE.test();
        Singleton_07.INSTANCE.test();
    }

}
