package com.team3d.quiz.quizapp.entities.dto;

public class QuizDTOForEdit {
    private Long id;
    private String title;
    private String desc;
    private double time;


    public QuizDTOForEdit(Long id, String title, String desc, double time, Long courseId, Long teacherId) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.time = time;

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public double getTime() {
        return time;
    }

}
