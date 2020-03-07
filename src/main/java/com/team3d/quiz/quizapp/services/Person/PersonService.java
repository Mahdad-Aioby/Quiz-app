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

                // If designation is specified in filter, add equal where clause
                if (filter.getFirstname() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("firstname"), filter.getFirstname()));
                }

                // If firstName is specified in filter, add contains (lile)
                // filter to where clause with ignore case
                if (filter.getNationalcode() != null) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nationalcode")),
                            "%" + filter.getNationalcode().toLowerCase() + "%"));
                }

                // If lastName is specified in filter, add contains (lile)
                // filter to where clause with ignore case
                if (filter.getAccount() != null) {


                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        });

    }





}
