package com.zhaoyd.mediator;

import java.sql.Connection;
import java.util.Map;

/**
 * <p>
 * 中介者设计模式
 * 中介者模式是要解决的问题就是复杂功能应用之间
 * 的重复调用，在这中间添加一层中介者包装服务，对外
 * 提供简单、通用、易扩展的服务能力
 *
 *  @Description: 配置类
 *  @author: zhao_yd
 *  @Date: 2021/8/20 11:02 上午
 *
 */

public class Configuration {

    protected Connection connection;
    protected Map<String,String> dataSource;
    protected Map<String,XNode> mapperElement;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setDataSource(Map<String, String> dataSource) {
        this.dataSource = dataSource;
    }

    public void setMapperElement(Map<String, XNode> mapperElement) {
        this.mapperElement = mapperElement;
    }
}
