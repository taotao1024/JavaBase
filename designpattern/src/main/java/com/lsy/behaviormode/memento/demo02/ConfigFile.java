package com.lsy.behaviormode.memento.demo02;

import java.util.Date;

/**
 * 原配置文件
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/17
 */
public class ConfigFile {
    /**
     * 版本号
     */
    private String versionNo;
    /**
     * 内容
     */
    private String content;
    /**
     * 时间
     */
    private Date dateTime;
    /**
     * 操作人
     */
    private String operator;

    /**
     * 构造方法
     *
     * @param versionNo 版本号
     * @param content   内容
     * @param dateTime  时间
     * @param operator  操作人
     */
    public ConfigFile(String versionNo, String content, Date dateTime, String operator) {
        this.versionNo = versionNo;
        this.content = content;
        this.dateTime = dateTime;
        this.operator = operator;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
