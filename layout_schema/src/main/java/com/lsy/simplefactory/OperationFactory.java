package com.lsy.simplefactory;

import com.lsy.simplefactory.base.BaseOperation;
import com.lsy.simplefactory.base.impl.OpeartionAdd;
import com.lsy.simplefactory.base.impl.OpeartionSub;

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
