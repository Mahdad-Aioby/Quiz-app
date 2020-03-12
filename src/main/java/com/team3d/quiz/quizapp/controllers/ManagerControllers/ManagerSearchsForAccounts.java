package com.team3d.quiz.quizapp.controllers.ManagerControllers;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.Person;
import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.entities.dto.SearchDTOForManager;
import com.team3d.quiz.quizapp.services.AccountService;
import com.team3d.quiz.quizapp.services.Person.PersonService;
import com.team3d.quiz.quizapp.services.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ManagerSearchsForAccounts {

    private AccountService accountService;

    @Autowired
    public ManagerSearchsForAccounts(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping(value = "/searchAccount")
    private String getModel(Model model){
        model.addAttribute("search",new SearchDTOForManager());
        return "Managers/SearchAccount";

    }

    @PostMapping(value = "/searchAccount")
    public String getSearchAccountPage(@ModelAttribute("search") SearchDTOForManager searchDTOForManager , Model model){

        List<Account> accounts = accountService.searchAccount(searchDTOForManager);

        List<SearchDTOForManager> result = accounts.stream().map(account -> new SearchDTOForManager(account.getUsername(),account.getPerson().getFirstname(),account.getPerson().getLastname(),account.getPerson().getNationalcode(),account.getPerson().getPhonenumber(),account.getPerson().getEmail(),account.getRoles().stream().findAny().get().getRole())).collect(Collectors.toList());



        model.addAttribute("result",result);

        return "Managers/SearchAccount";
    }

}
