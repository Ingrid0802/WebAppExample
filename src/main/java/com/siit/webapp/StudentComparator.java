package com.siit.webapp;

import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getAverage(), student1.getAverage());
    }
}

