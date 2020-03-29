package com.team3d.quiz.quizapp.entities.dto;

import java.util.List;

public class QuizDTOWithDetails {

    private List<QuestionDTOForShow> questions;

    public QuizDTOWithDetails(List<QuestionDTOForShow> questions) {
        this.questions = questions;
    }

    public List<QuestionDTOForShow> getQuestions() {
        return questions;
    }
}
