package com.team3d.quiz.quizapp.entities.dto;

public class QuizDTOforShow {

    private Long id;
    private String title;
    private String desc;
    private double time;

    public QuizDTOforShow(Long id, String title, String desc, double time) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
