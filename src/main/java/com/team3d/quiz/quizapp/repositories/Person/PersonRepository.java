package com.team3d.quiz.quizapp.repositories.Person;

import com.team3d.quiz.quizapp.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
