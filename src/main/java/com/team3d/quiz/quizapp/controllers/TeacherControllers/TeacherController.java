package com.team3d.quiz.quizapp.controllers.TeacherControllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @GetMapping("/Teacher")
    public String getTeacherHomePage(){
        return "Teachers/TeacherHomePage";
    }

    @GetMapping("/DoSomething")
    @PreAuthorize("hasAuthority('AddSomeThing')")
    public String getToDo(){
        return "Profile";
    }


    @GetMapping("/my-courses")
    private String getMyCourses(){
        return "Teachers/MyCourses";
    }

    @GetMapping("/my-quiz")
    private String getMyquiz(){
        return "Teachers/MyQuiz";
    }

    @GetMapping("/my-questions")
    private String getMyQuestionPage(Model model,@RequestParam(name = "cid",required = false) Long cid){
        model.addAttribute("cid",cid);
        return "Teachers/MyQuestion";
    }
}
