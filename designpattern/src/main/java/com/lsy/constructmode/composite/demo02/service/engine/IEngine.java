package com.lsy.constructmode.composite.demo02.service.engine;


import com.lsy.constructmode.composite.demo02.model.aggregates.TreeRich;
import com.lsy.constructmode.composite.demo02.model.vo.EngineResult;

import java.util.Map;

/**
 * @author TT
 */
public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
