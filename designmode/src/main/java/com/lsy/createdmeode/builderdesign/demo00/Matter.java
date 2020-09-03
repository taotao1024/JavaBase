package com.lsy.createdmeode.builderdesign.demo00;

import java.math.BigDecimal;

/**
 * 装修物料
 *
 * @author TT
 */
public interface Matter {

    /**
     * 场景；地板、地砖、涂料、吊顶
     *
     * @return String 场景
     */
    String scene();

    /**
     * 品牌
     *
     * @return String 品牌
     */
    String brand();

    /**
     * 型号
     *
     * @return String 型号
     */
    String model();

    /**
     * 平米报价
     *
     * @return String 平米报价
     */
    BigDecimal price();

    /**
     * 描述
     *
     * @return String 描述
     */
    String desc();

}
