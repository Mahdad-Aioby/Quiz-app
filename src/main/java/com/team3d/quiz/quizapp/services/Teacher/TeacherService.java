package com.team3d.quiz.quizapp.services.Teacher;

import com.team3d.quiz.quizapp.entities.Teacher;
import com.team3d.quiz.quizapp.entities.dto.ListTeacherDTOForCourses;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface TeacherService {

    List<ListTeacherDTOForCourses> Teachers();

    void addTeacherToCourse(List<Long> longs);



}
