package com.lsy.simplefactory.demo01;

/**
 * 出参对象
 *
 * @author TT
 */
public class AwardRes {
    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String info;

    /**
     * 构造方法
     *
     * @param code 编码
     * @param info 描述
     */
    public AwardRes(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
