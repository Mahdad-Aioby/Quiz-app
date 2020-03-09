package com.team3d.quiz.quizapp.services.Teacher.TeacherHimSelfServices;

import com.team3d.quiz.quizapp.entities.dto.ListCourseDTO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyTeacherService {

    List<ListCourseDTO> showMyCourses(Long teacherId);

    Long getCurrentTeacher();

}
