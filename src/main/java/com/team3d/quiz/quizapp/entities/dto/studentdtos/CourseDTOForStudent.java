package com.team3d.quiz.quizapp.entities.dto.studentdtos;

import java.util.List;

public class CourseDTOForStudent {

    private Long id;

    private String courseTitle;

    private List<CourseQuizDTOforStudent> courseQuizDTOforStudent;

    public CourseDTOForStudent(Long id, String courseTitle, List<CourseQuizDTOforStudent> courseQuizDTOforStudent) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.courseQuizDTOforStudent = courseQuizDTOforStudent;


    }

    public Long getId() {
        return id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public List<CourseQuizDTOforStudent> getCourseQuizDTOforStudent() {
        return courseQuizDTOforStudent;
    }
}
