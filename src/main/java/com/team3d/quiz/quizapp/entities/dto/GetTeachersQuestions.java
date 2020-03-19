package com.team3d.quiz.quizapp.entities.dto;

import java.util.List;

public class GetTeachersQuestions {
    private Long id;
    private String question;
    private List<ChoiceDTO> choiceDTOS;

    public GetTeachersQuestions(Long id, String question, List<ChoiceDTO> choiceDTOS) {
        this.id = id;
        this.question = question;
        this.choiceDTOS = choiceDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ChoiceDTO> getChoiceDTOS() {
        return choiceDTOS;
    }

    public void setChoiceDTOS(List<ChoiceDTO> choiceDTOS) {
        this.choiceDTOS = choiceDTOS;
    }
}
