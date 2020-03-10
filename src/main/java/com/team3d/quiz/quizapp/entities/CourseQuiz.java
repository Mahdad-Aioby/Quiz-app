package com.team3d.quiz.quizapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "quiz")
public class CourseQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quizTitle;
    private String quizDesc;
    private double quizTime;

    @ManyToOne
    @JsonIgnore
    private Course course;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

    public CourseQuiz(String quizTitle,String quizDesc,double quizTime,Course course,Teacher teacher) {
        this.quizTitle = quizTitle;
        this.quizDesc = quizDesc;
        this.quizTime = quizTime;
        this.course = course;
        this.teacher = teacher;
    }

    public CourseQuiz() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getQuizDesc() {
        return quizDesc;
    }

    public void setQuizDesc(String quizDesc) {
        this.quizDesc = quizDesc;
    }

    public double getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(double quizTime) {
        this.quizTime = quizTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
