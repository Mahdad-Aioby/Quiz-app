package com.team3d.quiz.quizapp.controllers;


import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.entities.Teacher;
import com.team3d.quiz.quizapp.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }



    @GetMapping(value = "/signup")
    private String getModel(Model model){
        model.addAttribute("account",new Account());
        return "MainPages/Signup";

    }

    @PostMapping(value = "/signup")
    private String signUpUser(@ModelAttribute Account account){
        accountService.saveAccount(account);

        return "login";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "MainPages/Login";
    }

}
