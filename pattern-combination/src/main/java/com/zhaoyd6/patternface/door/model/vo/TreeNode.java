package com.zhaoyd6.patternface.door.model.vo;


import java.util.List;

/**
 *  @Description: 规则树节点信息
 *  @author: zhao_yd
 *  @Date: 2021/7/30 11:05 上午
 *
 */

public class TreeNode {

    private Long treeId; //规则树ID
    private Long treeNodeId; //规则树节点ID
    private Integer nodeType; //节点类型 1、子叶 2、果实
    private String nodeValue; //节点值[nodeType=2] 果实值
    private String ruleKey;   //规则key
    private String ruleDesc;  //规则描述
    private List<TreeNodeLink> treeNodeLinkList; //节点链路

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(Long treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public List<TreeNodeLink> getTreeNodeLinkList() {
        return treeNodeLinkList;
    }

    public void setTreeNodeLinkList(List<TreeNodeLink> treeNodeLinkList) {
        this.treeNodeLinkList = treeNodeLinkList;
    }
}
