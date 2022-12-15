package com.siit.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {

    @Autowired
    StudentComparator studentComparator;

    public CatalogueService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    private final StudentsRepository studentsRepository;
    public String createStudentCatalogue(){
        List<Student> studentListToBeProcessed = studentsRepository.getStudents();
        String result = "";

        for (Student student: studentListToBeProcessed) {
            result = result.concat(student.getFirstName()).concat(" ").concat(student.getLastName().concat("<br></br>"));
        }

        return result;
    }

    public Double calculateAverage(Student student){
        int sum = 0;
        List<Integer> grades = student.getGrades();

        if(grades.isEmpty()){
            return 0.0;
        }

        for(Integer grade : grades){
            sum += grade;
        }

        return sum/(double)grades.size();
    }

    public String returnRank(){
        List<Student> rankedStudents = studentsRepository.getStudents();
        rankedStudents.forEach(student -> student.setAverage(calculateAverage(student)));
        rankedStudents.sort(studentComparator);
        String result = "";

        for (Student student : rankedStudents) {
            result = result.concat(student.getFirstName()).concat(" ").concat(student.getLastName()
                    .concat(" -> ").concat(student.getAverage().toString()).concat("<br></br>"));
        }

        return result;
    }

}
