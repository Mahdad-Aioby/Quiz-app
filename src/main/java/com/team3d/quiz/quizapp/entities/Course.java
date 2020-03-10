package com.team3d.quiz.quizapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(mappedBy = "courses" , cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<CourseQuiz> courseQuizs;
    private Date startDate;
    private Date endDate;
    private String status;
    private String courseTitle;
    private String courseDesc;

    public Course() {
    }

    public List<CourseQuiz> getCourseQuizs() {
        return courseQuizs;
    }

    public void setCourseQuizs(List<CourseQuiz> courseQuizs) {
        this.courseQuizs = courseQuizs;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
