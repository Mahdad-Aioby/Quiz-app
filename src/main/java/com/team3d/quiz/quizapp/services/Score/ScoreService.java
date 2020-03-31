package com.team3d.quiz.quizapp.services.Score;

import com.team3d.quiz.quizapp.entities.CourseQuiz;
import com.team3d.quiz.quizapp.entities.QuestionEntities.Score;
import com.team3d.quiz.quizapp.entities.dto.ScoreDTOforQuestion;
import com.team3d.quiz.quizapp.repositories.Score.ScoreRepository;
import com.team3d.quiz.quizapp.services.Course.CourseService;
import com.team3d.quiz.quizapp.services.Course.CourseServiceImplementation;
import com.team3d.quiz.quizapp.services.Question.QuestionService;
import com.team3d.quiz.quizapp.services.Question.QuestionServiceImplementation;
import com.team3d.quiz.quizapp.services.Quiz.QuizService;
import com.team3d.quiz.quizapp.services.Quiz.QuizServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private ScoreRepository scoreRepository;
    private QuestionService questionService;
    private QuizService quizService;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository, QuestionServiceImplementation questionService, QuizServiceImplementation quizService) {
        this.scoreRepository = scoreRepository;
        this.questionService = questionService;
        this.quizService = quizService;
    }

    public void ScoreQuestion(ScoreDTOforQuestion scoreDTOforQuestion)
    {

        scoreRepository.save(new Score(scoreDTOforQuestion.getScoreVal().floatValue(),
                                       questionService.getQuestionById(scoreDTOforQuestion.getQuestionId()),
                                       quizService.getQuizById(scoreDTOforQuestion.getQuizId())
                                       ));

    }
}
