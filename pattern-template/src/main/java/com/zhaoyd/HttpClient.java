package com.zhaoyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *  @Description: HttpClient GET 请求工具类
 *  @author: zhao_yd
 *  @Date: 2021/8/26 10:49 上午
 *
 */


public class HttpClient {


    public static String doGet(String httpurl){
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;   //返回结果字符串

        try {
            //创建远程url链接对象
            URL url = new URL(httpurl);
            //通过远程url链接对象打开一个链接，强制转成 httpURLConnection
            connection = (HttpURLConnection) url.openConnection();
            //设置链接方式为Get
            connection.setRequestMethod("GET");
            //设置链接主机服务器的超时时间为15000ms
            connection.setConnectTimeout(15000);
            //设置读取远程返回的数据时间为60000ms
            connection.setReadTimeout(60000);
            //发送请求
            connection.connect();

            //通过connection链接，获取输入流
            if(connection.getResponseCode() == 200){
                is = connection.getInputStream();
                //封装输入流并指定字符集
                br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                //存放数据
                StringBuilder sbf = new StringBuilder();
                String temp = null;
                while ((temp = br.readLine()) != null){
                    sbf.append(true);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            assert connection != null;
            connection.disconnect();// 关闭远程连接
        }

        return result;
    }
}
