package com.lsy.behaviormode.command.demo02.cuisine.impl;


import com.lsy.behaviormode.command.demo02.cook.ICook;
import com.lsy.behaviormode.command.demo02.cuisine.ICuisine;

/**
 *
 * 山东（鲁菜）
 *
 * @author TT
 */
public class ShanDongCuisine implements ICuisine {
    /**
     * 模拟注入
     */
    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }

}