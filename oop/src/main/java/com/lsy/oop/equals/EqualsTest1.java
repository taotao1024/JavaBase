package com.lsy.oop.equals;

/**
 * @author 19134
 */
public class EqualsTest1 {
    public static void main(String[] args) {
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        /**
         * 我们通过 p1.equals(p2) 来“比较p1和p2是否相等时”。 实际上，调用的Object.java的equals()方法，即调用的 (p1==p2) 。
         * 它是比较“p1和p2是否是同一个对象”。 而由 p1 和 p2 的定义可知，它们虽然内容相同； 但它们是两个不同的对象！因此，返回结果是false。
         */
        System.out.printf("%s\n", p1.equals(p2));

    }

    /**
     * @desc Person类。
     */
    private static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " - " + age;
        }
    }
}
