package com.lsy.behaviormode.command.demo02.cuisine.impl;


import com.lsy.behaviormode.command.demo02.cook.ICook;
import com.lsy.behaviormode.command.demo02.cuisine.ICuisine;

/**
 *
 * 江苏（苏菜）
 *
 * @author TT
 */
public class JiangSuCuisine implements ICuisine {
    /**
     * 模拟注入
     */
    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }

}