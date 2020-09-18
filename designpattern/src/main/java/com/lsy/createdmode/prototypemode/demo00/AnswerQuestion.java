package com.lsy.createdmode.prototypemode.demo00;

/**
 * 解答题
 *
 * @author TT
 */
public class AnswerQuestion {
    /**
     * 问题
     */
    private String name;
    /**
     * 答案
     */
    private String key;

    /**
     * 午餐构造方法
     */
    public AnswerQuestion() {
    }

    /**
     * 有参构造方法
     *
     * @param name 题目名称
     * @param key  答案
     */
    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
