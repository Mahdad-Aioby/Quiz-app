package com.team3d.quiz.quizapp.services;

import com.team3d.quiz.quizapp.entities.*;
import com.team3d.quiz.quizapp.entities.dto.AccountDTO;
import com.team3d.quiz.quizapp.repositories.AccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    private RoleService roleService;

    public AccountService(AccountRepository accountRepository, RoleService roleService) {
        this.accountRepository = accountRepository;
        this.roleService = roleService;
    }

    public Account saveAccount(Account account){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Role role = roleService.getRole(account.getRequestedRole());
        List<Role> roles = new ArrayList<Role>(){{add(role);}};
        account.setRoles(roles);
        return accountRepository.save(account);
    }

    public Account getAccountByUserName(String username){
        return accountRepository.getAccountByUsername(username);
    }

    public List<AccountDTO> getAccountList(){

        List<AccountDTO> accounts= accountRepository.findAll().stream().map(account -> new AccountDTO(account.getId(),account.getUsername(),account.getPassword(),account.isActive(),account.isAccountNonExpired(),account.getRoles())).filter(accountDTO -> accountDTO.isActive()==false).collect(Collectors.toList());


        return accounts;
    }

    public void activeAllById(List<Long> accounts){

        for(Long id : accounts){
            Account account = accountRepository.getOne(id);
            account.setActive(true);
            accountRepository.save(account);
        }
    }

}
