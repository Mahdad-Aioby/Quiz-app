package com.team3d.quiz.quizapp.controllers.TeacherControllers;


import com.team3d.quiz.quizapp.entities.CourseQuiz;
import com.team3d.quiz.quizapp.entities.dto.QuizDTOForCreate;
import com.team3d.quiz.quizapp.entities.dto.QuizDTOForEdit;
import com.team3d.quiz.quizapp.entities.dto.QuizDTOforShow;
import com.team3d.quiz.quizapp.services.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Quiz")
public class TeacherWorksWithQuizController {

    private QuizService quizService;

    @Autowired
    public TeacherWorksWithQuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/CreateQuiz")
    private void addQuiz(@RequestBody QuizDTOForCreate quizDTOForCreate)
    {
        quizService.addQuiz(quizDTOForCreate);
    }

    @PostMapping("/get-quiz-i-created")
    private List<QuizDTOforShow> getAllMyQuiz(@RequestBody Long courseid)
    {
       return quizService.getAllCoursesById(courseid);
    }

    @PostMapping("/get-all-my-quiz")
    private List<QuizDTOforShow> getAllMyQuiz()
    {

        List<QuizDTOforShow> quizDTOforShows = quizService.getAllOfMyQuiz();
        return quizDTOforShows;
    }

    @PostMapping("/Edit")
    private void editQuiz(@RequestBody QuizDTOforShow quizDTOforShow)
    {
        quizService.update(quizDTOforShow);
    }

    @PostMapping("/delete-quiz")
    private void editQuiz(@RequestBody Long quizId)
    {
        quizService.delete(quizId);
    }
}
