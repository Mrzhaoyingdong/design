package com.zhaoyd6.patternface.door.service.engine;

import com.zhaoyd6.patternface.door.model.aggregates.TreeRich;
import com.zhaoyd6.patternface.door.model.vo.EngineResult;

import java.util.Map;

public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);
}
