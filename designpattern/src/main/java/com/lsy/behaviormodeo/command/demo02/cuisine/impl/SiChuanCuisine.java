package com.lsy.behaviormodeo.command.demo02.cuisine.impl;


import com.lsy.behaviormodeo.command.demo02.cook.ICook;
import com.lsy.behaviormodeo.command.demo02.cuisine.ICuisine;

/**
 * 四川（川菜）
 *
 * @author TT
 */
public class SiChuanCuisine implements ICuisine {
    /**
     * 模拟注入
     */
    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }

}