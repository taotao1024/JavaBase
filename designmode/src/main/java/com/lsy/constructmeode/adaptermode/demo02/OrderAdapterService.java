package com.lsy.constructmeode.adaptermode.demo02;

/**
 * 适配接口
 */
public interface OrderAdapterService {
    /**
     * 是否是第一个
     *
     * @param uId 用户ID
     * @return boolean
     */
    boolean isFirst(String uId);

}
