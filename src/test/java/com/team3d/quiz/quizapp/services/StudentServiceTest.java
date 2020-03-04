package com.team3d.quiz.quizapp.services;

import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.services.Student.StudentService;
import org.junit.jupiter.api.Test;

class StudentServiceTest {

    @Test
    void students() {
        Student fetchManagersCriteria = new Student();
        fetchManagersCriteria.setFirstname("mahdad");

        StudentService employeeService = new StudentService();
        employeeService.students(fetchManagersCriteria);
    }
}