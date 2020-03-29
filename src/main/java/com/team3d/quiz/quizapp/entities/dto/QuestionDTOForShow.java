package com.team3d.quiz.quizapp.entities.dto;

import java.util.List;

public class QuestionDTOForShow {
    private Long id;

    private String question;

    private List<ChoiceDTO> choices;

    public QuestionDTOForShow(Long id, String question, List<ChoiceDTO> choices) {
        this.id = id;
        this.question = question;
        this.choices = choices;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<ChoiceDTO> getChoices() {
        return choices;
    }
}
