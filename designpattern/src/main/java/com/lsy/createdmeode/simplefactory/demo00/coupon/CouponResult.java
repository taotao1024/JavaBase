package com.lsy.createdmeode.simplefactory.demo00.coupon;

/**
 * 优惠卷结果
 *
 * @author TT
 */
public class CouponResult {

    /**
     * 描述
     */
    private String info;

    /**
     * 编码
     */
    private String code;

    /**
     * 构造方法
     *
     * @param code 编码
     * @param info 描述
     */
    public CouponResult(String code, String info) {
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
