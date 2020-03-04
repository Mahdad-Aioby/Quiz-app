package com.team3d.quiz.quizapp.controllers.StudentControllers;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.services.AccountService;
import com.team3d.quiz.quizapp.services.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("hasRole('ROLE_STUDENT')")
public class ProfileController {

    private StudentService studentService;
    private AccountService accountService;

    @Autowired
    public ProfileController(StudentService studentService, AccountService accountService) {
        this.studentService = studentService;
        this.accountService = accountService;
    }



    @GetMapping("/StudentCreateProfile")
    public String getCreateProfilePage(Model model){
        model.addAttribute("student",new Student());
        return "Students/Profile";
    }

    @PostMapping("/SaveProfile")
    public String saveStudentProfile(Model model){
        Student student = (Student) model.getAttribute("student");
       // Account account = accountService.getAccountByUserName()
        studentService.saveProfile(student);
        return "Students/StudentHomePage";
    }
}
