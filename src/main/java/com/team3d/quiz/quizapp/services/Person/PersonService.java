package com.team3d.quiz.quizapp.services.Person;

import com.team3d.quiz.quizapp.entities.Person;
import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.repositories.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
