package com.lsy.oop.finaldemo;

/**
 * 创建不可变类，但成员变量为可变类
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/14
 */
public class CreateFinalClass {
    private final Name name;

    public CreateFinalClass(Name name) {
        this.name = new Name(name.getFirstName(), name.getLastName());
    }

    public Name getName() {
        return new Name(name.getFirstName(), name.getLastName());
    }
}

class Name {
    private String firstName;
    private String lastName;

    public Name() {
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}