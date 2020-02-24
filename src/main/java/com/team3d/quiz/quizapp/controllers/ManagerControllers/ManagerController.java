package com.team3d.quiz.quizapp.controllers.ManagerControllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasRole('ROLE_MANAGER')")
public class ManagerController {

    @GetMapping("/Manager")
    public String getManagerHomePage(){
        return "Managers/ManagerHomePage";
    }
}
