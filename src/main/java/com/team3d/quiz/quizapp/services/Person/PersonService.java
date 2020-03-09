package com.team3d.quiz.quizapp.services.Person;

import com.team3d.quiz.quizapp.entities.*;
import com.team3d.quiz.quizapp.repositories.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void saveProfile(Person person){

        personRepository.save(person);
    }


    public List<Person> people(Person filter) {

        return personRepository.findAll(new Specification<Person>(){

            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (filter.getFirstname() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("firstname"), filter.getFirstname()));
                }


                if (filter.getNationalcode() != null) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nationalcode")),
                            "%" + filter.getNationalcode().toLowerCase() + "%"));
                }


                if (filter.getAccount() != null) {


                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        });

    }





}
