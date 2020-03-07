package com.team3d.quiz.quizapp.controllers.ManagerControllers;


import com.team3d.quiz.quizapp.entities.dto.ListStudentDTOForCourses;
import com.team3d.quiz.quizapp.services.Student.StudentService;
import com.team3d.quiz.quizapp.services.Student.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerWorksWithStudents {

    private StudentService studentService;

    @Autowired
    public ManagerWorksWithStudents(StudentServiceImplementation studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/get-all-students")
    private List<ListStudentDTOForCourses> getAllStudents(){
        return studentService.students();
    }

    @PostMapping("/add-student-to-course")
    private void addStudentToCourse(@RequestBody List<Long> longs){
        studentService.addStudentToCourse(longs);
    }
}
