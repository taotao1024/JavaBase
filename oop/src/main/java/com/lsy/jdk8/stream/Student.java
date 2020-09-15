package com.lsy.jdk8.stream;

/**
 * @author TT
 */
public class Student {
    /**
     * ID
     */
    private Grade grade;
    /**
     * 年纪
     */
    private Integer score;
    /**
     * 分数
     */
    private Integer id;

    public Student(Integer id, Grade grade, Integer score) {
        this.id = id;
        this.grade = grade;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

