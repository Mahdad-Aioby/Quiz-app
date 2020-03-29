package com.team3d.quiz.quizapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Teacher extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private Set<Course> courses;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<CourseQuiz> courseQuizs;

    public Teacher() {
        super();
    }

    public List<CourseQuiz> getCourseQuizs() {
        return courseQuizs;
    }

    public void setCourseQuizs(List<CourseQuiz> courseQuizs) {
        this.courseQuizs = courseQuizs;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
