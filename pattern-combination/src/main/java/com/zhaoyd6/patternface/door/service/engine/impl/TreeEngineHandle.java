package com.zhaoyd6.patternface.door.service.engine.impl;

import com.zhaoyd6.patternface.door.model.aggregates.TreeRich;
import com.zhaoyd6.patternface.door.model.vo.EngineResult;
import com.zhaoyd6.patternface.door.model.vo.TreeNode;
import com.zhaoyd6.patternface.door.service.engine.EngineBase;

import java.util.Map;

public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {

        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);

        return new EngineResult(userId,treeId,treeNode.getTreeNodeId(),treeNode.getNodeValue());
    }
}
