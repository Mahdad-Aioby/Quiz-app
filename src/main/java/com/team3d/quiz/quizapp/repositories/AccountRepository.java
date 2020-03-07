package com.team3d.quiz.quizapp.repositories;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.dto.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account getAccountByUsername(String username);


}
