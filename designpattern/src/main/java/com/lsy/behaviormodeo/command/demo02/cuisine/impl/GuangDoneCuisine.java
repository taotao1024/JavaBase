package com.lsy.behaviormodeo.command.demo02.cuisine.impl;

import com.lsy.behaviormodeo.command.demo02.cook.ICook;
import com.lsy.behaviormodeo.command.demo02.cuisine.ICuisine;

/**
 *
 *
 * 广东（粤菜）
 */
public class GuangDoneCuisine implements ICuisine {

    private ICook cook;

    public GuangDoneCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
