package com.lsy.constructmeode.composite.demo02.service.logic.impl;


import com.lsy.constructmeode.composite.demo02.service.logic.BaseLogic;

import java.util.Map;

/**
 * @author TT
 */
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }

}
