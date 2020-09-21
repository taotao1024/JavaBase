package com.lsy.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 苹果过滤
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/18
 */
public class FilterApple {
    /**
     * Apple数组
     */
    static List<Apple> inventory;

    /**
     * 初始化
     */
    public static void init() {
        inventory = Arrays.asList(
                new Apple(50, "green"),
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(200, "green"),
                new Apple(80, "red"),
                new Apple(50, "red"),
                new Apple(155, "red"),
                new Apple(200, "red")
        );
    }

    /**
     * 入口
     *
     * @param args 参数数组
     */
    public static void main(String... args) {

        FilterApple.init();

        // [Apple{color='green', weight=50}, Apple{color='green', weight=80}, Apple{color='green', weight=155}, Apple{color='green', weight=200}]
        List<Apple> greenApples = filterApples(inventory, FilterApple::isGreenApple);

        // [Apple{color='green', weight=155}, Apple{color='green', weight=200}, Apple{color='red', weight=155}, Apple{color='red', weight=200}]
        List<Apple> heavyApples = filterApples(inventory, FilterApple::isHeavyApple);

        // [Apple{color='green', weight=50}, Apple{color='green', weight=80}, Apple{color='green', weight=155}, Apple{color='green', weight=200}]
        List<Apple> greenApples2 = filterApples(inventory, a -> "green".equals(a.getColor()));

        List<Apple> greenApples3 = filterApples(inventory, (a) -> "red".equals(a.getColor()));

        // [Apple{color='green', weight=155}, Apple{color='green', weight=200}, Apple{color='red', weight=155}, Apple{color='red', weight=200}]
        List<Apple> heavyApples4 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);

        // [Apple{color='green', weight=50}, Apple{color='red', weight=50}]
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));

        prettyPrintApple(inventory, FilterApple::AppleFancyFormatter);
    }

    /**
     * 查找绿色的苹果
     *
     * @param inventory 详细目录
     * @return 绿色的苹果的数组
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 查找红色的苹果
     *
     * @param inventory 详细目录
     * @return 红色色的苹果的数组
     */
    public static List<Apple> filterRedApples(List<Apple> inventory) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("red".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 过滤重量
     *
     * @param inventory 详细目录
     * @return 过滤后的数组
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() >= 150) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 过滤苹果的方法
     *
     * @param inventory 苹果清单
     * @param p         JDK默认的函数式接口
     * @return 校验后的结果
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * 校验绿色苹果
     *
     * @param apple 苹果对象
     * @return Boolean
     */
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    /**
     * 校验红色苹果
     *
     * @param apple 苹果对象
     * @return Boolean
     */
    public static boolean isRedApple(Apple apple) {
        return "red".equals(apple.getColor());
    }

    /**
     * 校验苹果重量
     *
     * @param apple 苹果对象
     * @return Boolean
     */
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() >= 150;
    }

    public static void prettyPrintApple(List<Apple> inventory, Function<Apple, String> f) {
        for (Apple apple : inventory) {
            String output = f.apply(apple);
            System.out.println(output);
        }
    }

    private static String AppleFancyFormatter(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }

    /**
     * 内部类 苹果
     */
    public static class Apple {
        private int weight = 0;
        private String color = "";



        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Apple() {

        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

}
