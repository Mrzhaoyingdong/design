package com.zhaoyd6.patternface.door.service.logic.impl;

import com.zhaoyd6.patternface.door.service.logic.BaseLogic;

import java.util.Map;

public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
