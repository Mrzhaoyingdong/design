package com.zhaoyd6.patternface.door.service.logic;

import com.zhaoyd6.patternface.door.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 *  @Description: logic过滤器
 *  @author: zhao_yd
 *  @Date: 2021/7/30 3:22 下午
 *
 */

public interface LogicFilter {

    /**
     * 逻辑决策器
     *
     * @param matterValue        决策值
     * @param treeNodeLinkList   决策节点
     * @return 下一个节点Id
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);


    /**
     * 获取决策值
     *
     * @param treeId            树ID
     * @param userId            用户ID
     * @param decisionMatter    决策物料
     * @return
     */
    String matterValue(Long treeId, String userId , Map<String,String> decisionMatter);
}
