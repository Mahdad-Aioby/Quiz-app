package com.team3d.quiz.quizapp.entities.dto.studentdtos;

import com.team3d.quiz.quizapp.entities.dto.ChoiceDTO;

import java.util.List;

public class QuestionDTOforStudent {
    private Long id;

    private String question;

    private List<ChoiceDTOForStudent> choices;

    public QuestionDTOforStudent(Long id, String question, List<ChoiceDTOForStudent> choices) {
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

    public List<ChoiceDTOForStudent> getChoices() {
        return choices;
    }
}
