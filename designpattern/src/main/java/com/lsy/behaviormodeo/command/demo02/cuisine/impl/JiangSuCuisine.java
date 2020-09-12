package com.lsy.behaviormodeo.command.demo02.cuisine.impl;


import com.lsy.behaviormodeo.command.demo02.cook.ICook;
import com.lsy.behaviormodeo.command.demo02.cuisine.ICuisine;

/**
 * 江苏（苏菜）
 */
public class JiangSuCuisine implements ICuisine {

    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}