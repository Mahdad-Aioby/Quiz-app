package com.team3d.quiz.quizapp.entities.dto;

import java.util.List;

public class QuestionDTOForAdd {
   private String title;
   private List<String> correct;
   private List<String> incorrect;

    public QuestionDTOForAdd(String title, List<String> correct, List<String> incorrect) {
        this.title = title;
        this.correct = correct;
        this.incorrect = incorrect;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCorrect() {
        return correct;
    }

    public List<String> getIncorrect() {
        return incorrect;
    }
}
