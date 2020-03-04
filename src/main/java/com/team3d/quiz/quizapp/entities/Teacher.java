package com.team3d.quiz.quizapp.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
