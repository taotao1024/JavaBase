package com.lsy.createdmeode.simplefactory.demo02;


import com.lsy.createdmeode.simplefactory.demo02.store.ICommodity;
import com.lsy.createdmeode.simplefactory.demo02.store.impl.CardCommodityService;
import com.lsy.createdmeode.simplefactory.demo02.store.impl.CouponCommodityService;
import com.lsy.createdmeode.simplefactory.demo02.store.impl.GoodsCommodityService;

/**
 * 商场工厂
 *
 * @author TT
 */
public class StoreFactory {
    /**
     * 创建工厂
     *
     * @param commodityType
     * @return
     */
    public ICommodity createCommodityFactory(Integer commodityType) {
        if (null == commodityType) {
            return null;
        } else if (1 == commodityType) {
            return new CouponCommodityService();
        } else if (2 == commodityType) {
            return new GoodsCommodityService();
        } else if (3 == commodityType) {
            return new CardCommodityService();
        } else {
            throw new RuntimeException("不存在的商品服务类型");
        }
    }

}
