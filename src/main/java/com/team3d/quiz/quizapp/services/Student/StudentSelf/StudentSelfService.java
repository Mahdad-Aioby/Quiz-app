package com.team3d.quiz.quizapp.services.Student.StudentSelf;

import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.entities.dto.studentdtos.CourseDTOForStudent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface StudentSelfService {
    Set<CourseDTOForStudent> studentCourses(String username);

    Long getByUsername(String username);
}
