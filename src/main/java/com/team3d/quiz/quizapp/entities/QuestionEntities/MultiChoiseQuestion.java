package com.team3d.quiz.quizapp.entities.QuestionEntities;

import com.team3d.quiz.quizapp.entities.CourseQuiz;
import com.team3d.quiz.quizapp.entities.Teacher;

import javax.persistence.*;
import java.util.List;

@Entity
public class MultiChoiseQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @ManyToMany(cascade =  CascadeType.ALL)
    @JoinTable(
            name = "question_choice",
            joinColumns = { @JoinColumn(name = "question_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "choice_id",referencedColumnName = "id") }
    )
    private List<Choice> choices;



    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToOne
    private Teacher teacher;


    public MultiChoiseQuestion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }


}

