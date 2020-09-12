package com.lsy.behaviormodeo.command.demo02.cuisine.impl;


import com.lsy.behaviormodeo.command.demo02.cook.ICook;
import com.lsy.behaviormodeo.command.demo02.cuisine.ICuisine;

/**
 *
 *
 * 山东（鲁菜）
 */
public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}