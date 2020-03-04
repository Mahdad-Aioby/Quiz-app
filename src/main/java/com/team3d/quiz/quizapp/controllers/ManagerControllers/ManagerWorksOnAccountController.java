package com.team3d.quiz.quizapp.controllers.ManagerControllers;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_MANAGER')")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ManagerWorksOnAccountController {

    private AccountService  accountService;

    @Autowired
    public ManagerWorksOnAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/listAccounts")
    public String getAccounts(Model model){

        List<Account> accounts = accountService.getAccountList();
        model.addAttribute("accounts",accounts);
        return "Managers/ListAccounts";

    }

    @RequestMapping(value = "/activeAllSelected" , method = RequestMethod.POST)
    public String active(@RequestParam(value = "myselected[]") List<String> strings)
    {

        List<Long> longs = new ArrayList<>();
        for (String s:strings)
            longs.add(Long.parseLong(s));

        accountService.activeAllById(longs);
        return "/Managers/ListAccounts";
    }



}
