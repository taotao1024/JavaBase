package com.lsy.newjdk.stream;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author TT
 */
public class TestStream {
    public static void main(String[] args) {
        final Collection<Student> students = Arrays.asList(
                new Student(1, Grade.FIRST, 60),
                new Student(2, Grade.SECOND, 80),
                new Student(3, Grade.FIRST, 100)
        );
        List<Student> gradeOneStudents = Lists.newArrayList();
        for (Student student : students) {
            if (Grade.FIRST.equals(student.getGrade())) {
                gradeOneStudents.add(student);
            }
        }
        Collections.sort(gradeOneStudents, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });
        List<Integer> studentIds = new ArrayList<>();
        for (Student t : gradeOneStudents) {
            studentIds.add(t.getId());
        }
        System.out.println(studentIds);
    }
}
