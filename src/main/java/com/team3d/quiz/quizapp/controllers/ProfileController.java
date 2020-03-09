package com.team3d.quiz.quizapp.controllers;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.Person;
import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.entities.Teacher;
import com.team3d.quiz.quizapp.services.AccountService;
import com.team3d.quiz.quizapp.services.Person.PersonService;
import com.team3d.quiz.quizapp.services.Student.StudentProfileService;
import com.team3d.quiz.quizapp.services.Student.StudentProfileServiceImplementation;
import com.team3d.quiz.quizapp.services.Student.StudentService;
import com.team3d.quiz.quizapp.services.Student.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.DiscriminatorValue;
import java.security.Principal;

@Controller
@PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_TEACHER','ROLE_MANAGER')")
public class ProfileController {

    private StudentProfileService studentProfileService;
    private AccountService accountService;

    @Autowired
    public ProfileController(StudentProfileServiceImplementation studentProfileService, AccountService accountService) {
        this.studentProfileService = studentProfileService;
        this.accountService = accountService;
    }



    @GetMapping("/StudentCreateProfile")
    public String getCreateProfilePage(Model model){
        model.addAttribute("person",new Person());
        return "Students/Profile";
    }

    @GetMapping("/TeacherCreateProfile")
    public String getCreateProfile(Model model){
        model.addAttribute("person",new Person());
        return "Teachers/Profile";
    }

    @PostMapping("/SaveProfile")
    public String saveStudentProfile(@ModelAttribute Person person, Principal principal){
        Student student = new Student();
        Teacher teacher = new Teacher();
        Account account = accountService.getAccountByUserName(principal.getName());
        if(account.getRoles().stream().findAny().get().getRole().equals("ROLE_TEACHER"))
            {
                teacher.setFirstname(person.getFirstname());
                teacher.setLastname(person.getLastname());
                teacher.setNationalcode(person.getNationalcode());
                teacher.setEmail(person.getEmail());
                teacher.setPhonenumber(person.getPhonenumber());
                account.setPerson(teacher);
                teacher.setAccount(account);
                studentProfileService.saveProfile(student);
            }
          if(account.getRoles().stream().findAny().get().getRole().equals("ROLE_STUDENT"))
           {
               student.setFirstname(person.getFirstname());
               student.setLastname(person.getLastname());
               student.setNationalcode(person.getNationalcode());
               student.setEmail(person.getEmail());
               student.setPhonenumber(person.getPhonenumber());
               account.setPerson(student);
               student.setAccount(account);
               studentProfileService.saveProfile(student);
           }


        return "Students/StudentHomePage";
    }
}
