package com.team3d.quiz.quizapp.controllers.TeacherControllers;

import com.team3d.quiz.quizapp.entities.dto.EditSelfQuestionDTO;
import com.team3d.quiz.quizapp.entities.dto.GetTeachersQuestions;
import com.team3d.quiz.quizapp.entities.dto.QuestionDTOForAdd;
import com.team3d.quiz.quizapp.entities.dto.ScoreDTOforQuestion;
import com.team3d.quiz.quizapp.services.Question.QuestionService;
import com.team3d.quiz.quizapp.services.Question.QuestionServiceImplementation;
import com.team3d.quiz.quizapp.services.Score.ScoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Question")
public class TeacherWorksWithQuestionController {

    private QuestionService questionService;
    private ScoreService scoreService;


    public TeacherWorksWithQuestionController(QuestionServiceImplementation questionService,ScoreService scoreService) {
        this.questionService = questionService;
        this.scoreService = scoreService;

    }

    @PostMapping("/add-question")
    private void addQuestionByTeacher(@RequestBody QuestionDTOForAdd dtoForAdd)
    {

        questionService.addQuestionByTeacher(dtoForAdd);
    }

    @PostMapping("/get-Questions-i-created")
    private List<GetTeachersQuestions> getTeachersQuestions(){
        List<GetTeachersQuestions> getTeachersQuestions = questionService.QUESTIONS();
        return getTeachersQuestions;
    }

    @PostMapping("/EditSelf")
    private void editQuestion(@RequestBody EditSelfQuestionDTO editSelfQuestionDTO){

        questionService.updateQuestionItSelf(editSelfQuestionDTO);

    }

    @PostMapping("/score-question")
    private void scoreQuestionOfQuiz(@RequestBody ScoreDTOforQuestion scoreDTOforQuestion){
        System.out.println("after");
        scoreService.ScoreQuestion(scoreDTOforQuestion);
    }
}
