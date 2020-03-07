package com.team3d.quiz.quizapp.controllers.ManagerControllers;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_MANAGER')")
public class ManagerController {


    private AccountService accountService;

    public ManagerController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/Manager")
    public String getManagerHomePage(){
        return "Managers/ManagerHomePage";
    }

    @GetMapping("/CourseManagerPage")
    public String showCourseManagerPage(){
        return "Managers/WorkOnCourses";

    }

    @GetMapping("/add-teacher-course")
    public String showTeacherCoursePage(){
        return "Managers/TeacherCourse";

    }



}
