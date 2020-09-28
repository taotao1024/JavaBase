package com.lsy.oop.enumdemo;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/28
 */
public enum Operation {
    /**
     * 加法操作
     */
    PLUS {
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    /**
     * 减法操作
     */
    MINUS {
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    /**
     * 乘法操作
     */
    TIMES {
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    },
    /**
     * 除法操作
     */
    DIVIDE {
        @Override
        public double eval(double x, double y) {
            return x / y;
        }
    };

    /**
     * @param x
     * @param y
     * @return
     */
    public abstract double eval(double x, double y);
}
