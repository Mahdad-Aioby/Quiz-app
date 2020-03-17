package com.team3d.quiz.quizapp.entities.QuestionEntities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean currect;
    @ManyToMany
    @JoinTable(
            name = "question_choice",
            joinColumns = { @JoinColumn(name = "choice_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "question_id",referencedColumnName = "id") }
    )
    private List<MultiChoiseQuestion> questions;

    public Choice() {
    }

    public Choice(String title,boolean currect) {
        this.title=title;
        this.currect=currect;
    }

    public boolean isCurrect() {
        return currect;
    }

    public void setCurrect(boolean currect) {
        this.currect = currect;
    }

    public List<MultiChoiseQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<MultiChoiseQuestion> questions) {
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
