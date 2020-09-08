package com.lsy.constructmeode.compositepattern.demo02.service.engine;


import com.lsy.constructmeode.compositepattern.demo02.service.logic.LogicFilter;
import com.lsy.constructmeode.compositepattern.demo02.service.logic.impl.UserAgeFilter;
import com.lsy.constructmeode.compositepattern.demo02.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@author TT
 */
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }

}
