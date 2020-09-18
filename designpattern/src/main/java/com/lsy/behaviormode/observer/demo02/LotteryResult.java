package com.lsy.behaviormode.observer.demo02;

import java.util.Date;

/**
 * 抽象对象
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/17
 */
public class LotteryResult {
    /**
     * 用户ID
     */
    private String uId;
    /**
     * 摇号信息
     */
    private String msg;
    /**
     * 业务时间
     */
    private Date dateTime;

    public LotteryResult(String uId, String msg, Date dateTime) {
        this.uId = uId;
        this.msg = msg;
        this.dateTime = dateTime;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
