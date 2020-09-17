package com.lsy.createdmode.simplefactory.demo02;


import com.lsy.createdmode.simplefactory.demo02.store.ICommodity;
import com.lsy.createdmode.simplefactory.demo02.store.impl.CardCommodityService;
import com.lsy.createdmode.simplefactory.demo02.store.impl.CouponCommodityService;
import com.lsy.createdmode.simplefactory.demo02.store.impl.GoodsCommodityService;

/**
 * 商场工厂
 *
 * @author TT
 */
public class StoreFactory {

    /**
     * 爱奇艺卡片标识
     */
    private final int IQY_CODE = 3;
    /**
     * 优惠卷标识
     */
    private final int COUPON_CODE = 2;
    /**
     * 实体礼物标识
     */
    private final int GOODS_CODE = 1;

    /**
     * 创建工厂
     *
     * @param commodityType
     * @return
     */
    public ICommodity createCommodityFactory(Integer commodityType) {
        if (null == commodityType) {
            return null;
        } else if (GOODS_CODE == commodityType) {
            return new CouponCommodityService();
        } else if (COUPON_CODE == commodityType) {
            return new GoodsCommodityService();
        } else if (IQY_CODE == commodityType) {
            return new CardCommodityService();
        } else {
            throw new RuntimeException("不存在的商品服务类型");
        }
    }

}
