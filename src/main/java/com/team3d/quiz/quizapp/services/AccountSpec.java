package com.team3d.quiz.quizapp.services;

import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.Person;
import com.team3d.quiz.quizapp.entities.Role;
import com.team3d.quiz.quizapp.entities.dto.SearchDTOForManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountSpec implements Specification<Account> {

    private SearchDTOForManager account;

    public SearchDTOForManager getAccount() {
        return account;
    }

    public void setAccount(SearchDTOForManager account) {
        this.account = account;
    }

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        setAttributeForCriteria(predicates, root, criteriaBuilder);
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    protected void setAttributeForCriteria(List<Predicate> predicates, Root<Account> root, CriteriaBuilder criteriaBuilder) {
        setUsername(root, criteriaBuilder, predicates, account.getUsername());
        setFirstName(root, criteriaBuilder, predicates, account.getFirstName());
        setLastName(root, criteriaBuilder, predicates, account.getLastName());
        setNationalCode(root, criteriaBuilder, predicates, account.getNationalCode());
        setPhoneNumber(root, criteriaBuilder, predicates, account.getPhoneNumber());
        setEmail(root, criteriaBuilder, predicates, account.getEmail());
        setRole(root, criteriaBuilder, predicates, account.getRole());
//        setStatus(root, criteriaBuilder, predicates, account.getStatus());
    }

    private void setUsername(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String username) {
        if (username != null && !username.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("username"), "%" + username.trim() + "%"));
        }
    }

    private void setFirstName(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.like(accountPersonJoin.get("firstname"), "%" + firstName.trim() + "%"));
        }
    }

    private void setLastName(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.like(accountPersonJoin.get("lastname"), "%" + lastName.trim() + "%"));
        }
    }

    private void setNationalCode(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String nationalCode) {
        if (nationalCode != null && !nationalCode.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.like(accountPersonJoin.get("nationalcode"), "%" + nationalCode.trim() + "%"));
        }
    }

    private void setPhoneNumber(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.like(accountPersonJoin.get("phonenumber"), "%" + phoneNumber.trim() + "%"));
        }
    }

    private void setEmail(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String email) {
        if (email != null && !email.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.like(accountPersonJoin.get("email"), "%" + email.trim() + "%"));
        }
    }


    private void setRole(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String role) {
        if (role != null && !role.isEmpty()) {
            Join<Account, Role> accountRoleJoin = root.join("roles");
            predicates.add(criteriaBuilder.equal(accountRoleJoin.get("role"), role));
        }
    }

//    private void setStatus(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String status) {
//        if (status != null && !status.isEmpty()) {
//            predicates.add(criteriaBuilder.equal(root.get("accountStatus"), status));
//        }
//    }
}
