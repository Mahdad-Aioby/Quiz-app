package com.team3d.quiz.quizapp.entities.dto;

import org.springframework.lang.Nullable;

import java.util.List;

public class QuestionDTOForAdd {
   private String title;
   private List<String> correct;
   private List<String> incorrect;
   private Long cid;

    public QuestionDTOForAdd(String title, List<String> correct, List<String> incorrect,Long cid) {
        this.title = title;
        this.correct = correct;
        this.incorrect = incorrect;
        this.cid = cid;
    }

    public Long getCid() {
        return cid;
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
