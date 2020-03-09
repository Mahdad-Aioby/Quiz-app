package com.team3d.quiz.quizapp.services.Teacher;

import com.team3d.quiz.quizapp.entities.Teacher;
import com.team3d.quiz.quizapp.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Access;

public class TeacherProfileServiceImplementation implements TeacherProfileService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherProfileServiceImplementation(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void savaProfile(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
