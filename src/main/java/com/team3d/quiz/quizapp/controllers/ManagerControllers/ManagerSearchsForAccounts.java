package com.team3d.quiz.quizapp.controllers.ManagerControllers;

import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.services.Student.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ManagerSearchsForAccounts {

    private StudentService studentService;


    public ManagerSearchsForAccounts(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/searchAccount")
    private String getModel(Model model){
        model.addAttribute("student",new Student());
        return "Managers/SearchAccount";

    }

    @PostMapping(value = "/searchAccount")
    public String getSearchAccountPage(@ModelAttribute("student") Student student , Model model){

        List<Student> students = studentService.students(student);
        model.addAttribute("students",students);

        return "Managers/SearchAccount";
    }

}
