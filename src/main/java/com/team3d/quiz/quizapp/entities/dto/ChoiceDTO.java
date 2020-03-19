package com.team3d.quiz.quizapp.entities.dto;

public class ChoiceDTO {
    private Long id;
    private String title;
    private boolean currect;

    public ChoiceDTO(Long id, String title, boolean currect) {
        this.id = id;
        this.title = title;
        this.currect = currect;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCurrect() {
        return currect;
    }
}
