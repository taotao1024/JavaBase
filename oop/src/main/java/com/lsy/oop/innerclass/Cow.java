package com.lsy.oop.innerclass;

import com.sun.glass.ui.ClipboardAssistance;

/**
 * 内部类访问外部私有变量
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/16
 */
public class Cow {
    private double weight;

    public Cow() {
    }

    public Cow(double weight) {
        this.weight = weight;
    }

    /**
     * 非静态内部类
     */
    private class CowLeg {
        /**
         * 非静态内部类的实例变量
         */
        private double length;
        /**
         * 非静态内部类的实例变量
         */
        private String color;

        public CowLeg() {
        }

        public CowLeg(double length, String color) {
            this.length = length;
            this.color = color;
        }

        public void info() {
            System.out.println("内部类的成员变量1:" + length + " 内部类的成员变量2:" + color);
            System.out.println("内部类访问外部类的Private成员变量:" + weight);
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public void test() {
        CowLeg cowLeg = new CowLeg(1.2, "黑白");
        cowLeg.info();
    }
}
