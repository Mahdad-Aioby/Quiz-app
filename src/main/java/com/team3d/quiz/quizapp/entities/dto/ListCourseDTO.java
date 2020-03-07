package com.team3d.quiz.quizapp.entities.dto;

import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.entities.Teacher;


import java.util.List;

public class ListCourseDTO {
    private Long id;
    private String startDate;
    private String endDate;
    private String status;
    private String courseTitle;
    private String courseDesc;
    private List<Student> students;
    private Teacher teacher;

    public ListCourseDTO(Long id, List<Student> students, Teacher teacher, String startDate, String endDate, String status, String courseTitle, String courseDesc) {
        this.id = id;
        this.students = students;
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.courseTitle = courseTitle;
        this.courseDesc = courseDesc;
    }

    public Long getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }
}
