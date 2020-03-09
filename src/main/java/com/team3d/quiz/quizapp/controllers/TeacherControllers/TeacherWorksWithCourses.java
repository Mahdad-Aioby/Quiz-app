package com.team3d.quiz.quizapp.controllers.TeacherControllers;


import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.dto.ListCourseDTO;
import com.team3d.quiz.quizapp.services.Teacher.TeacherHimSelfServices.MyTeacherService;
import com.team3d.quiz.quizapp.services.Teacher.TeacherHimSelfServices.MyTeacherServiceImplementation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Teacher",method = RequestMethod.POST)
public class TeacherWorksWithCourses {

    private MyTeacherService myTeacherService;

    public TeacherWorksWithCourses(MyTeacherServiceImplementation myTeacherService) {
        this.myTeacherService = myTeacherService;
    }

    @PostMapping("/get-courses-i-teach")
    private List<ListCourseDTO> myCourses(){

        return myTeacherService.showMyCourses(myTeacherService.getCurrentTeacher());



    }

}
