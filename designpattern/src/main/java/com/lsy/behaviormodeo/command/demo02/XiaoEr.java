package com.lsy.behaviormodeo.command.demo02;

import com.lsy.behaviormodeo.command.demo02.cuisine.ICuisine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * 饭店小二，负责点单
 *
 * @author TT
 */
public class XiaoEr {

    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    /**
     * 菜单
     */
    private List<ICuisine> cuisineList = new ArrayList<ICuisine>();

    /**
     * 添加订单
     *
     * @param cuisine 烹饪
     */
    public void order(ICuisine cuisine) {
        cuisineList.add(cuisine);
    }

    /**
     * 消费
     */
    public synchronized void placeOrder() {
        for (ICuisine cuisine : cuisineList) {
            cuisine.cook();
        }
        cuisineList.clear();
    }

}
