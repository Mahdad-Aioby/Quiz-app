package com.team3d.quiz.quizapp.controllers.ManagerControllers;


import com.team3d.quiz.quizapp.entities.Teacher;
import com.team3d.quiz.quizapp.entities.dto.ListTeacherDTOForCourses;
import com.team3d.quiz.quizapp.services.Teacher.TeacherService;
import com.team3d.quiz.quizapp.services.Teacher.TeacherServiceImplementation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_MANAGER')")
public class ManagerWorksWithTeachers {

    private TeacherService teacherService;

    public ManagerWorksWithTeachers(TeacherServiceImplementation teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(value = "/get-all-teachers")
    public List<ListTeacherDTOForCourses> getAllTeachers()
    {
        return teacherService.Teachers();
    }

    @PostMapping(value = "/add-teacher")
    public void add(@RequestBody List<Long> longs)
    {
        teacherService.addTeacherToCourse(longs);
    }


}
