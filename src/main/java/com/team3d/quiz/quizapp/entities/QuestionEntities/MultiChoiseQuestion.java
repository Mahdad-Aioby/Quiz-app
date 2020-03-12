package com.team3d.quiz.quizapp.entities.QuestionEntities;

import com.team3d.quiz.quizapp.entities.Teacher;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "MultiChoiseQuestion")
public class MultiChoiseQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @OneToMany(mappedBy = "multiChoiseQuestion")
    private Set<Option> options;

    @OneToOne
    private Teacher teacher;



}
