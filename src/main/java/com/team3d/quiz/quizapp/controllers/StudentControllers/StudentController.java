package com.team3d.quiz.quizapp.controllers.StudentControllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@PreAuthorize("hasRole('ROLE_STUDENT')")
public class StudentController {

    @GetMapping("/Student")
    public String getStudentHomePage(Principal principal, Model model){
        model.addAttribute("account",principal);
        return "Students/StudentHomePage";
    }

    @GetMapping("/Student/get-my-courses")
    private String getStudentCourses(){
        return "Students/MyCourses";
    }
}
