package com.lsy.oop.equalsdemo;

import java.util.Objects;

/**
 * 比较equals() 返回true 以及 返回false时， hashCode()的值。
 *
 * @author 19134
 */
public class NormalHashCodeTest {
    public static void main(String[] args) {
        Person p1 = new Person("a", 1);
        Person p2 = new Person("a", 1);
        Person p3 = new Person("b", 2);
        /**
         * p1和p2相等的情况下，hashCode()也不一定相等。
         * 所以如果不创建散列函表，对象相等于HashCode无关。
         */
        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
        System.out.printf("p1.equals(p3) : %s; p1(%d) p3(%d)\n", p1.equals(p3), p1.hashCode(), p3.hashCode());
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

        /**
         * 1. 对称性：如果x.equals(y)返回是"true"，那么y.equals(x)也应该返回是"true"。
         * 2. 反射性：x.equals(x)必须返回是"true"。
         * 3. 类推性：如果x.equals(y)返回是"true"，而且y.equals(z)返回是"true"，那么z.equals(x)也应该返回是"true"。
         * 4. 一致性：如果x.equals(y)返回是"true"，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是"true"。
         * 5. 非空性，x.equals(null)，永远返回是"false"；x.equals(和x不同类型的对象)永远返回是"false"。
         *
         * @param o Object
         * @return boolean
         */
        @Override
        public boolean equals(Object o) {
            // 如果地址相等
            if (this == o) {
                return true;
            }
            // 如果对象为空、判断对象是否为同类型
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            // 判断对象的内容
            return age == person.age && Objects.equals(name, person.name);
        }

    }
}
