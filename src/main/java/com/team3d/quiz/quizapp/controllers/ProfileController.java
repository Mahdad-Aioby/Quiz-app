package com.team3d.quiz.quizapp.controllers;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.Person;
import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.services.AccountService;
import com.team3d.quiz.quizapp.services.Person.PersonService;
import com.team3d.quiz.quizapp.services.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@PreAuthorize("hasRole('ROLE_STUDENT')")
public class ProfileController {

    private PersonService personService;
    private AccountService accountService;

    @Autowired
    public ProfileController(PersonService personService, AccountService accountService) {
        this.personService = personService;
        this.accountService = accountService;
    }



    @GetMapping("/StudentCreateProfile")
    public String getCreateProfilePage(Model model){
        model.addAttribute("person",new Person());
        return "Students/Profile";
    }

    @PostMapping("/SaveProfile")
    public String saveStudentProfile(@ModelAttribute Person person, Principal principal){
        Account account = accountService.getAccountByUserName(principal.getName());
        account.setPerson(person);
        person.setAccount(account);
        personService.saveProfile(person);
        return "Students/StudentHomePage";
    }
}
