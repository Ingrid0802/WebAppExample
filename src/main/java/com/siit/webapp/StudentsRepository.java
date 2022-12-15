package com.siit.webapp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentsRepository {

    public List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student("Mihai", "Pop");
        Student student2 = new Student("Roxana", "Dobre");
        Student student3 = new Student("Vali", "Topescu");
        Student student4 = new Student("Alex", "Topescu");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        List<Integer> grades1 = Arrays.asList(10,4,5,7,8,9);
        List<Integer> grades2 = Arrays.asList(7,9,10,9,8,9);
        List<Integer> grades3 = Arrays.asList(10,9,10,10,10);
        student1.setGrades(grades1);
        student2.setGrades(grades2);
        student3.setGrades(grades3);

        return studentList;
    }
}
