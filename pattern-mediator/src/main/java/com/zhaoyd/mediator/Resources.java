package com.zhaoyd.mediator;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *  Resources
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/8/20 11:12 上午
 *
 */

public class Resources {


    public static Reader getResourceAsReader(String resource) throws IOException {
        return new InputStreamReader(getResourceAsStream(resource));
    }

    private static InputStream getResourceAsStream(String resource) throws IOException {
        ClassLoader[] classLoaders = getClassLoaders();
        for(ClassLoader classLoader : classLoaders){
            InputStream resourceAsStream = classLoader.getResourceAsStream(resource);
            if(null != resourceAsStream){
                return resourceAsStream;
            }
        }
        throw new IOException("Could not find resource " +resource);
    }

    private static ClassLoader[] getClassLoaders(){
        return new ClassLoader[]{
                ClassLoader.getSystemClassLoader(),
                Thread.currentThread().getContextClassLoader()
        };
    }
}
