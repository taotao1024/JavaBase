package com.lsy.createdmeode.builder.demo01;

import com.lsy.createdmeode.builder.demo00.Matter;
import com.lsy.createdmeode.builder.demo00.ceiling.LevelOneCeiling;
import com.lsy.createdmeode.builder.demo00.ceiling.LevelTwoCeiling;
import com.lsy.createdmeode.builder.demo00.coat.DuluxCoat;
import com.lsy.createdmeode.builder.demo00.coat.LiBangCoat;
import com.lsy.createdmeode.builder.demo00.floor.ShengXiangFloor;
import com.lsy.createdmeode.builder.demo00.tile.DongPengTile;
import com.lsy.createdmeode.builder.demo00.tile.MarcoPoloTile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TT
 */
public class DecorationPackageController {

    final int LEVEL_1 = 1;
    final int LEVEL_2 = 2;
    final int LEVEL_3 = 3;

    /**
     * 获取家具列表
     *
     * @param area  面积
     * @param level 类型
     * @return 家具详情
     */
    public String getMatterList(BigDecimal area, Integer level) {

        // 装修清单
        List<Matter> list = new ArrayList<Matter>();
        // 装修价格
        BigDecimal price = BigDecimal.ZERO;

        /*
         * 豪华欧式:
         * 吊顶，一级顶
         * 涂料，多乐士
         * 地板，圣象
         */
        if (LEVEL_1 == level) {
            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();
            DuluxCoat duluxCoat = new DuluxCoat();
            ShengXiangFloor shengXiangFloor = new ShengXiangFloor();
            this.addMaterials(list, levelOneCeiling, duluxCoat, shengXiangFloor);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelOneCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(duluxCoat.price()));
            price = price.add(area.multiply(shengXiangFloor.price()));

        }
        /* 轻奢田园:
         * 吊顶，二级顶
         * 涂料，立邦
         * 地砖，马可波罗
         */
        if (LEVEL_2 == level) {

            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            LiBangCoat liBangCoat = new LiBangCoat();
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();
            this.addMaterials(list, levelTwoCeiling, liBangCoat, marcoPoloTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(marcoPoloTile.price()));

        }

        /* 现代简约
         * 吊顶，二级顶
         * 涂料，立邦
         * 地砖，东鹏
         */
        if (LEVEL_3 == level) {

            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();
            LiBangCoat liBangCoat = new LiBangCoat();
            DongPengTile dongPengTile = new DongPengTile();
            this.addMaterials(list, levelOneCeiling, liBangCoat, dongPengTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelOneCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(dongPengTile.price()));
        }

        StringBuilder result = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + level + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");
        for (Matter matter : list) {
            result.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }
        return result.toString();
    }

    /**
     * 添加材料
     *
     * @return
     */
    private List addMaterials(List list, Matter... matters) {
        // 遍历添加
        for (byte i = 1; i < matters.length; i++) {
            list.add(matters[i]);
        }
        return list;
    }

}
