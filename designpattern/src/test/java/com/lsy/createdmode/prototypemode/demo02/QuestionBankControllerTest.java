package com.lsy.createdmode.prototypemode.demo02;

import org.junit.Test;

/**
 * 构建者模式乱序测试
 * @author TT
 */
public class QuestionBankControllerTest {

    QuestionBankController questionBankController = new QuestionBankController();

    @Test
    public void createPaper01() throws CloneNotSupportedException {
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
    }

    @Test
    public void createPaper02() throws CloneNotSupportedException {
        System.out.println(questionBankController.createPaper("豆豆", "1000001921051"));
    }

    @Test
    public void createPaper03() throws CloneNotSupportedException {
        System.out.println(questionBankController.createPaper("大宝", "1000001921987"));
    }
}