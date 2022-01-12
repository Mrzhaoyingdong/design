package com.zhaoyd6.patternface.door.service.engine;

import com.zhaoyd6.patternface.door.model.aggregates.TreeRich;
import com.zhaoyd6.patternface.door.model.vo.EngineResult;
import com.zhaoyd6.patternface.door.model.vo.TreeNode;
import com.zhaoyd6.patternface.door.model.vo.TreeRoot;
import com.zhaoyd6.patternface.door.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public abstract class EngineBase extends EngineConfig implements IEngine {

    private Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String,String> decisionMatter) {

        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();

        //规则树根ID
        Long treeRootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNode = treeNodeMap.get(treeRootNodeId);

        //节点类型[NodeType]；1子叶、2果实
        while (treeNode.getNodeType().equals(1)) {

            String ruleKey = treeNode.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);

            Long nextNode = logicFilter.filter(matterValue, treeNode.getTreeNodeLinkList());
            treeNode = treeNodeMap.get(nextNode);
            logger.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), userId, treeId, treeNode.getTreeNodeId(), ruleKey, matterValue);
        }
        return treeNode;
    }

}
