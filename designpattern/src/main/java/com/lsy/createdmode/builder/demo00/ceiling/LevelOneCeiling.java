package com.lsy.createdmode.builder.demo00.ceiling;


import com.lsy.createdmode.builder.demo00.Matter;

import java.math.BigDecimal;

/**
 * 吊顶
 * 品牌；装修公司自带
 * 型号：一级顶
 *
 * @author TT
 */
public class LevelOneCeiling implements Matter {


    @Override
    public String scene() {
        return "吊顶";
    }


    @Override
    public String brand() {
        return "装修公司自带";
    }


    @Override
    public String model() {
        return "一级顶";
    }


    @Override
    public BigDecimal price() {
        return new BigDecimal(260);
    }


    @Override
    public String desc() {
        return "造型只做低一级，只有一个层次的吊顶，一般离顶120-150mm";
    }

}
