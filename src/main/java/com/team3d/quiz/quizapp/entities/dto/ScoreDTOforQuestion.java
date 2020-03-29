package com.team3d.quiz.quizapp.entities.dto;

public class ScoreDTOforQuestion {


    private Long questionId;
    private Long quizId;
    private Long ScoreVal;

    public ScoreDTOforQuestion(Long questionId, Long quizId, Long scoreVal) {
        this.questionId = questionId;
        this.quizId = quizId;
        ScoreVal = scoreVal;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public Long getScoreVal() {
        return ScoreVal;
    }
}
