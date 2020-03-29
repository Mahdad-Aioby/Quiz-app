package com.team3d.quiz.quizapp.entities.dto;

public class EditSelfQuestionDTO {
    private Long id;
    private String title;

    public EditSelfQuestionDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
