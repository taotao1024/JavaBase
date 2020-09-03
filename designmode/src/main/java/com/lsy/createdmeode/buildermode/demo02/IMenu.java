package com.lsy.createdmeode.buildermode.demo02;

import com.lsy.createdmeode.buildermode.demo00.Matter;

/**
 * 菜单
 *
 * @author TT
 */
public interface IMenu {

    /**
     * 吊顶
     *
     * @param matter 吊顶
     * @return IMenu 菜单
     */
    IMenu appendCeiling(Matter matter);

    /**
     * 涂料
     *
     * @param matter 涂料
     * @return IMenu 菜单
     */
    IMenu appendCoat(Matter matter);

    /**
     * 地板
     *
     * @param matter 地板
     * @return IMenu 菜单
     */
    IMenu appendFloor(Matter matter);

    /**
     * 地砖
     *
     * @param matter 地砖
     * @return IMenu 菜单
     */
    IMenu appendTile(Matter matter);

    /**
     * 获取细节
     *
     * @return String 菜单
     */
    String getDetail();

}
