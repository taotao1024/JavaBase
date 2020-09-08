package com.lsy.constructmeode.compositepattern.demo01;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class EngineControllerTest {
    private Logger logger = LoggerFactory.getLogger(EngineControllerTest.class);

    @Test
    public void test_EngineController() {
        EngineController engineController = new EngineController();
        String process = engineController.process("Oli09pLkdjh", "man", 29);
        logger.info("测试结果：{}", process);
    }
}