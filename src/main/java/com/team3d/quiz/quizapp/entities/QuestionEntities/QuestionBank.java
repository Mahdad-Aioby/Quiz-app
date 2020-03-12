package com.team3d.quiz.quizapp.entities.QuestionEntities;

import javax.persistence.*;
import java.util.List;
//@Entity
//@Table(name = "QuestionBank")
public class QuestionBank {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<MultiChoiseQuestion> multiChoiseQuestions;

}
