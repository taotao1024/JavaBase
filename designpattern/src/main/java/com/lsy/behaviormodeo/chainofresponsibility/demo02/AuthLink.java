package com.lsy.behaviormodeo.chainofresponsibility.demo02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 审核规定；
 * 1. 三级审批 + 二级审批
 * 2. 三级审批 + 二级审批 + 一级审批
 * 3. 其他时间 三级审批
 */
public abstract class AuthLink {

    protected Logger logger = LoggerFactory.getLogger(AuthLink.class);

    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间格式化
    protected String levelUserId;                           // 级别人员ID
    protected String levelUserName;                         // 级别人员姓名
    private AuthLink next;                                  // 责任链

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    /**
     * 下一个节点
     *
     * @return
     */
    public AuthLink next() {
        return next;
    }

    /**
     * 追加下一个节点
     *
     * @param next AuthLink
     * @return AuthLink
     */
    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}
