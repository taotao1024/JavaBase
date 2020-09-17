package com.lsy.createdmode.simplefactory.demo03;


import com.lsy.createdmode.simplefactory.demo03.base.BaseOperation;
import com.lsy.createdmode.simplefactory.demo03.base.OpeartionAdd;
import com.lsy.createdmode.simplefactory.demo03.base.OpeartionSub;

/**
 * 运算类工厂
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
public class OperationFactory {

    /**
     * 1+
     * <p/>
     * 2-
     *
     * @param type 1 2
     * @return BaseOperation
     */
    BaseOperation createFactory(int type) {
        if (type <= 0) {
            throw new NullPointerException("NPU");
        }
        BaseOperation result = null;
        switch (type) {
            case 1:
                result = new OpeartionAdd();
                break;
            case 2:
                result = new OpeartionSub();
                break;
            default:
                throw new NullPointerException("Factory Create fail");
        }
        return result;
    }
}
