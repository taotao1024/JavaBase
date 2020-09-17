package com.lsy.behaviormode.command.demo02.cuisine.impl;

import com.lsy.behaviormode.command.demo02.cook.ICook;
import com.lsy.behaviormode.command.demo02.cuisine.ICuisine;

/**
 *
 * 广东（粤菜）
 *
 * @author TT
 */
public class GuangDoneCuisine implements ICuisine {
    /**
     * 模拟注入
     */
    private ICook cook;

    public GuangDoneCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }

}
