package com.lsy.constructmode.composite.demo02.service.engine.impl;


import com.lsy.constructmode.composite.demo02.model.aggregates.TreeRich;
import com.lsy.constructmode.composite.demo02.model.vo.EngineResult;
import com.lsy.constructmode.composite.demo02.model.vo.TreeNode;
import com.lsy.constructmode.composite.demo02.service.engine.BaseEngine;

import java.util.Map;

/**
 * @author TT
 */
public class TreeHandleEngine extends BaseEngine {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
