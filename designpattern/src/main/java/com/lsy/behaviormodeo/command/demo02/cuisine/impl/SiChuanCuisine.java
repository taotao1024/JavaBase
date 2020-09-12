package com.lsy.behaviormodeo.command.demo02.cuisine.impl;


import com.lsy.behaviormodeo.command.demo02.cook.ICook;
import com.lsy.behaviormodeo.command.demo02.cuisine.ICuisine;

/**
 * 四川（川菜）
 */
public class SiChuanCuisine implements ICuisine {

    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}