package com.team3d.quiz.quizapp.services;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.Role;
import com.team3d.quiz.quizapp.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    private RoleService roleService;

    public AccountService(AccountRepository accountRepository, RoleService roleService) {
        this.accountRepository = accountRepository;
        this.roleService = roleService;
    }

    public void saveAccount(Account account){
        Role role = roleService.getRole(account.getRequestedRole());
        List<Role> roles = new ArrayList<Role>(){{add(role);}};
        account.setRoles(roles);
        accountRepository.save(account);
    }


}
