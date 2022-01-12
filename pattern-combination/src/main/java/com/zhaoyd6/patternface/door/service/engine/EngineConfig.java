package com.zhaoyd6.patternface.door.service.engine;

import com.zhaoyd6.patternface.door.service.logic.LogicFilter;
import com.zhaoyd6.patternface.door.service.logic.impl.UserAgeFilter;
import com.zhaoyd6.patternface.door.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  @Description: Config
 *  @author: zhao_yd
 *  @Date: 2021/7/30 5:32 下午
 *
 */

public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public static Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public static void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }
}
