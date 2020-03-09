package com.team3d.quiz.quizapp.entities;

import javax.persistence.*;

@Table
@Entity
public class Manager extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
