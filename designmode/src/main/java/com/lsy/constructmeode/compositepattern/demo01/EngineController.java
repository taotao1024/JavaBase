package com.lsy.constructmeode.compositepattern.demo01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineController {

    private Logger logger = LoggerFactory.getLogger(EngineController.class);

    /**
     * 目标
     *
     * @param userId  用户ID
     * @param userSex 用户行呗
     * @param userAge 用户年龄
     * @return
     */
    public String process(final String userId, final String userSex, final int userAge) {

        logger.info("if-else实现方式判断用户结果。userId：{} userSex：{} userAge：{}", userId, userSex, userAge);

        if ("man".equals(userSex)) {
            if (userAge < 25) {
                return "果实A";
            }
            if (userAge >= 25) {
                return "果实B";
            }
        }
        if ("woman".equals(userSex)) {
            if (userAge < 25) {
                return "果实C";
            }
            if (userAge >= 25) {
                return "果实D";
            }
        }
        return null;
    }
}
