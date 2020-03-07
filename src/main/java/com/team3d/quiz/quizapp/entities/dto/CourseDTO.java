package com.team3d.quiz.quizapp.entities.dto;


public class CourseDTO {


    private String startDate;

    private String endDate;

    private String status;

    private String courseTitle;

    private String courseDesc;

    public CourseDTO(String startDate, String endDate, String status, String courseTitle, String courseDesc) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.courseTitle = courseTitle;
        this.courseDesc = courseDesc;
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
