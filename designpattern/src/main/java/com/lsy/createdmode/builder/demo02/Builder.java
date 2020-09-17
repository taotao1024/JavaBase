package com.lsy.createdmode.builder.demo02;


import com.lsy.createdmode.builder.demo00.ceiling.LevelOneCeiling;
import com.lsy.createdmode.builder.demo00.ceiling.LevelTwoCeiling;
import com.lsy.createdmode.builder.demo00.coat.DuluxCoat;
import com.lsy.createdmode.builder.demo00.coat.LiBangCoat;
import com.lsy.createdmode.builder.demo00.floor.ShengXiangFloor;
import com.lsy.createdmode.builder.demo00.tile.DongPengTile;
import com.lsy.createdmode.builder.demo00.tile.MarcoPoloTile;
import com.lsy.createdmode.builder.demo02.impl.DecorationPackageMenu;

/**
 * 构建着
 *
 * @author TT
 */
public class Builder {
    /**
     * 级别一
     *
     * @param area 面积
     * @return 菜单
     */
    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                // 吊顶，二级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料，多乐士
                .appendCoat(new DuluxCoat())
                // 地板，圣象
                .appendFloor(new ShengXiangFloor());
    }

    /**
     * 级别二
     *
     * @param area 面积
     * @return 菜单
     */
    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area, "轻奢田园")
                // 吊顶，二级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料，立邦
                .appendCoat(new LiBangCoat())
                // 地砖，马可波罗
                .appendTile(new MarcoPoloTile());
    }

    /**
     * 级别三
     *
     * @param area 面积
     * @return 菜单
     */
    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(area, "现代简约")
                // 吊顶，二级顶
                .appendCeiling(new LevelOneCeiling())
                // 涂料，立邦
                .appendCoat(new LiBangCoat())
                // 地砖，东鹏
                .appendTile(new DongPengTile());
    }

}
