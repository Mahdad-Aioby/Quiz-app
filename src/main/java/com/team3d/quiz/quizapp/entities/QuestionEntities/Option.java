package com.team3d.quiz.quizapp.entities.QuestionEntities;

import javax.persistence.*;

//@Entity
//@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean True;

    @ManyToOne
    private MultiChoiseQuestion multiChoiseQuestion;


}
