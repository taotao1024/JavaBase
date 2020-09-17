package com.lsy.createdmode.factorymethod.demo02;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/12
 */
public abstract class BaseOperation {
    private double numberA;
    private double numberB;

    /**
     * 获取结果
     *
     * @return
     */
    public double getResult() {
        double result = 0;
        return result;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }


}
