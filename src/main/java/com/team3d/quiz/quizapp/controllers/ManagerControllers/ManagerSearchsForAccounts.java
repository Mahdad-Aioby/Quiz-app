package com.team3d.quiz.quizapp.controllers.ManagerControllers;

import com.team3d.quiz.quizapp.entities.Person;
import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.services.Person.PersonService;
import com.team3d.quiz.quizapp.services.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ManagerSearchsForAccounts {

    private PersonService personService;

    @Autowired
    public ManagerSearchsForAccounts(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/searchAccount")
    private String getModel(Model model){
        model.addAttribute("person",new Person());
        return "Managers/SearchAccount";

    }

    @PostMapping(value = "/searchAccount")
    public String getSearchAccountPage(@ModelAttribute("person") Person person , Model model){

        List<Person> people = personService.people(person);
        model.addAttribute("people",people);

        return "Managers/SearchAccount";
    }

}
