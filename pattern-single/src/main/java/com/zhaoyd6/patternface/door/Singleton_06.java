package com.zhaoyd6.patternface.door;

import java.util.concurrent.atomic.AtomicReference;

/**
 *  @Description:  CAS̿ AtomicReferencè(线程安全)
 *  @author: zhao_yd
 *  @Date: 2021/7/26 10:15 上午
 *
 */

public class Singleton_06 {

    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<>();

    private static Singleton_06 instance;

    private Singleton_06(){}

    public static final Singleton_06 getInstance(){
        while (true){
            Singleton_06 instance = INSTANCE.get();
            if( null !=  instance){
                return instance;
            }
            INSTANCE.compareAndSet(null,new Singleton_06());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {

        System.out.println(Singleton_06.getInstance());
        System.out.println(Singleton_06.getInstance());
    }


}
