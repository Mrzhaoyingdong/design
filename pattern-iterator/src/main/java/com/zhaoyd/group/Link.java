package com.zhaoyd.group;
/**
 *  @Description: 树节点链路
 *  @author: zhao_yd
 *  @Date: 2021/8/12 5:19 下午
 *
 */

public class Link {

    private String fromId; //员工ID
    private String toId;  //员工ID

    public Link(String fromId, String toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }
}
