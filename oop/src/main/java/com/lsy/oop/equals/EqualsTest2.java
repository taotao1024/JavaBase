package com.lsy.oop.equals;

import java.util.Objects;

/**
 * @author 19134
 */
public class EqualsTest2 {
    public static void main(String[] args) {
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        /**
         * 我们中重写了Person的equals()函数：当两个Person对象的 name 和 age 都相等，则返回true。
         * 因此，运行结果返回true。
         */
        System.out.printf("重写Equals方法： %s\n", p1.equals(p2));
        System.out.printf("原生Equals方法： %s\n", p1 == p2);

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
            if (this == o) return true;
            // 如果对象为空、判断对象是否为同类型
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            // 判断对象的内容
            return age == person.age && Objects.equals(name, person.name);
        }

    }
}
