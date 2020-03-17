package com.team3d.quiz.quizapp.services.Quiz;

import com.team3d.quiz.quizapp.entities.CourseQuiz;
import com.team3d.quiz.quizapp.entities.dto.QuizDTOForCreate;
import com.team3d.quiz.quizapp.entities.dto.QuizDTOforShow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    void addQuiz(QuizDTOForCreate quizDTOForCreate);

    List<QuizDTOforShow> getAllCoursesById(Long courseId);

    void update(QuizDTOforShow quizDTOforShow);

    void delete(Long qid);

    List<QuizDTOforShow> getAllOfMyQuiz();

    CourseQuiz getQuizById(Long id);
}
