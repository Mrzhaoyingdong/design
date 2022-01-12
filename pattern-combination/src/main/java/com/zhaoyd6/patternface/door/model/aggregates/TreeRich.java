package com.zhaoyd6.patternface.door.model.aggregates;

import com.zhaoyd6.patternface.door.model.vo.TreeNode;
import com.zhaoyd6.patternface.door.model.vo.TreeRoot;

import java.util.Map;

/**
 *  @Description: 规则树聚合
 *  @author: zhao_yd
 *  @Date: 2021/7/30 3:10 下午
 *
 */

public class TreeRich {

    private TreeRoot treeRoot;  //树根信息
    private Map<Long, TreeNode> treeNodeMap; //树节点ID->子节点


    public TreeRich(TreeRoot treeRoot,Map<Long, TreeNode> treeNodeMap){
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
    }

    public TreeRoot getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRoot treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNode> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNode> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}
