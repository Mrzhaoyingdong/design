package com.zhaoyd6.patternface.door.service.logic.impl;

import com.zhaoyd6.patternface.door.service.logic.BaseLogic;

import java.util.Map;

/**
 *  @Description: 用户年龄过滤器
 *  @author: zhao_yd
 *  @Date: 2021/7/30 3:53 下午
 *
 */

public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
