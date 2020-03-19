package com.team3d.quiz.quizapp.controllers.TeacherControllers;

import com.team3d.quiz.quizapp.entities.dto.QuestionDTOForAdd;
import com.team3d.quiz.quizapp.services.Question.QuestionService;
import com.team3d.quiz.quizapp.services.Question.QuestionServiceImplementation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Question")
public class TeacherWorksWithQuestionController {

    private QuestionService questionService;


    public TeacherWorksWithQuestionController(QuestionServiceImplementation questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add-question")
    private void addQuestionByTeacher(@RequestBody QuestionDTOForAdd dtoForAdd)
    {
        System.out.println("after");
        questionService.addQuestionByTeacher(dtoForAdd);
    }
}
