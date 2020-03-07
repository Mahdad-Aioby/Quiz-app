package com.team3d.quiz.quizapp.entities.dto;

public class ListTeacherDTOForCourses {

    private Long id;
    private String firstname;
    private String lastname;

    public ListTeacherDTOForCourses(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
