package com.team3d.quiz.quizapp.services.Student;

import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.repositories.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImplementation implements StudentProfileService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentProfileServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveProfile(Student student) {
        studentRepository.save(student);
    }
}
