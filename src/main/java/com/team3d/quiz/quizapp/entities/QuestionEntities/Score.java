package com.team3d.quiz.quizapp.entities.QuestionEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.team3d.quiz.quizapp.entities.CourseQuiz;

import javax.persistence.*;

@Entity

//this score class needs a quiz id and a question id to score a question in a paticular quiz
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float point;

    @ManyToOne
    @JoinColumn(columnDefinition = "id")
    private MultiChoiseQuestion question;

    @ManyToOne
    @JoinColumn(columnDefinition = "id")
    private CourseQuiz courseQuiz;


    public Score() {
    }

    public Score(Float point,MultiChoiseQuestion multiChoiseQuestion,CourseQuiz courseQuiz) {
        this.point = point;
        this.question = multiChoiseQuestion;
        this.courseQuiz = courseQuiz;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    public MultiChoiseQuestion getQuestion() {
        return question;
    }

    public void setQuestion(MultiChoiseQuestion question) {
        this.question = question;
    }

    public CourseQuiz getCourseQuiz() {
        return courseQuiz;
    }

    public void setCourseQuiz(CourseQuiz courseQuiz) {
        this.courseQuiz = courseQuiz;
    }
}
