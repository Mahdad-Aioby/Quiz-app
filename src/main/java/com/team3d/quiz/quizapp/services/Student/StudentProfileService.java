package com.team3d.quiz.quizapp.services.Student;

import com.team3d.quiz.quizapp.entities.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentProfileService {

    void saveProfile(Student student);
}
