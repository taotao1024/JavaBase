package com.lsy.createdmeode.prototypemode.demo00;

import java.util.Map;

/**
 * 单选题
 *
 * @author TT
 */
public class ChoiceQuestion {
    /**
     * 题目
     */
    private String name;
    /**
     * 选项；A、B、C、D
     */
    private Map<String, String> option;
    /**
     * 答案；B
     */
    private String key;

    /**
     * 无参构造函数
     */
    public ChoiceQuestion() {
    }

    /**
     * 有参构造函数
     *
     * @param name   题目名称
     * @param option 选项
     * @param key    答案
     */
    public ChoiceQuestion(String name, Map<String, String> option, String key) {
        this.name = name;
        this.option = option;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getOption() {
        return option;
    }

    public void setOption(Map<String, String> option) {
        this.option = option;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
