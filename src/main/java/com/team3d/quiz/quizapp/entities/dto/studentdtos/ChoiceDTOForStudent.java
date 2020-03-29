package com.team3d.quiz.quizapp.entities.dto.studentdtos;

public class ChoiceDTOForStudent {

    private Long id;
    private String title;
    private boolean currect;

    public ChoiceDTOForStudent(Long id, String title, boolean currect) {
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
