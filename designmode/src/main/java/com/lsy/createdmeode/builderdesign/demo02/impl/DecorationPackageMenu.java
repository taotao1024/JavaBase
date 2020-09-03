package com.lsy.createdmeode.builderdesign.demo02.impl;

import com.lsy.createdmeode.builderdesign.demo00.Matter;
import com.lsy.createdmeode.builderdesign.demo02.IMenu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 装饰包菜单
 *
 * @author TT
 */
public class DecorationPackageMenu implements IMenu {

    /**
     * 装修清单
     */
    private List<Matter> list = new ArrayList<Matter>();
    /**
     * 装修价格
     */
    private BigDecimal price = BigDecimal.ZERO;

    /**
     * 面积
     */
    private BigDecimal area;
    /**
     * 装修等级；豪华欧式、轻奢田园、现代简约
     */
    private String grade;

    /**
     * 私有无参构造方法
     */
    private DecorationPackageMenu() {
    }

    /**
     * 构造函数
     *
     * @param area  面积
     * @param grade 级别
     */
    public DecorationPackageMenu(Double area, String grade) {
        this.area = new BigDecimal(area);
        this.grade = grade;
    }

    @Override
    public IMenu appendCeiling(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendCoat(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("1.4")).multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendFloor(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendTile(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public String getDetail() {
        // 细节
        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + grade + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter : list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();
    }
}
