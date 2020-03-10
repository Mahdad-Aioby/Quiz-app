package com.team3d.quiz.quizapp.entities.dto;

public class QuizDTOForCreate {


    private String title;
    private String desc;
    private double time;
    private Long cid;
    private Long tid;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public QuizDTOForCreate(String title, String desc, double time, Long cid) {
        this.title = title;
        this.desc = desc;
        this.time = time;
        this.cid = cid;
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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}
