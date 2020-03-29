package com.team3d.quiz.quizapp.controllers.TeacherControllers;


import com.team3d.quiz.quizapp.entities.CourseQuiz;
import com.team3d.quiz.quizapp.entities.dto.*;
import com.team3d.quiz.quizapp.services.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @PostMapping("/get-quiz")
    private List<QuestionDTOForShow> getQuizWithDetails(@RequestBody Long quizId)
    {

//        Function<CourseQuiz, QuizDTOWithDetails> externalToMyLocation
//                = t -> {
//                    QuizDTOWithDetails quizDTOWithDetails = new QuizDTOWithDetails(t.getMultiChoiseQuestions().stream().map(multiChoiseQuestion -> new QuestionDTOForShow(multiChoiseQuestion.getId(), multiChoiseQuestion.getQuestion(), multiChoiseQuestion.getChoices().stream().map(choice -> new ChoiceDTO(choice.getId(), choice.getTitle(), choice.isCurrect())).collect(Collectors.toList()))).collect(Collectors.toList()));
//
//                    return quizDTOWithDetails;
//                };
//
//
//        return externalToMyLocation.apply( quizService.getQuizById(quizId));

        return quizService.getQuizById(quizId).getMultiChoiseQuestions().stream().map(multiChoiseQuestion -> new QuestionDTOForShow(multiChoiseQuestion.getId(),multiChoiseQuestion.getQuestion(),multiChoiseQuestion.getChoices().stream().map(choice -> new ChoiceDTO(choice.getId(),choice.getTitle(),choice.isCurrect())).collect(Collectors.toList()))).collect(Collectors.toList());
    }

}
