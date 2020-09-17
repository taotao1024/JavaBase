package com.lsy.createdmode.prototypemode.demo02.util;

import java.util.Map;

/**
 * 题目
 * <p>
 * 题目于选项、答案分离，方便乱序
 *
 * @author TT
 */
public class Topic {

    /**
     * 选项；A、B、C、D
     */
    private Map<String, String> option;
    /**
     * 答案；B
     */
    private String key;

    /**
     * 构造方法
     */
    public Topic() {
    }

    /**
     * 有参构造方法
     *
     * @param option 选项
     * @param key    答案
     */
    public Topic(Map<String, String> option, String key) {
        this.option = option;
        this.key = key;
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
