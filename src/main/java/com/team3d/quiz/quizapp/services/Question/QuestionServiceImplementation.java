package com.team3d.quiz.quizapp.services.Question;

import com.team3d.quiz.quizapp.entities.QuestionEntities.Choice;
import com.team3d.quiz.quizapp.entities.QuestionEntities.MultiChoiseQuestion;
import com.team3d.quiz.quizapp.entities.dto.QuestionDTOForAdd;
import com.team3d.quiz.quizapp.repositories.Question.QuestionRepository;
import com.team3d.quiz.quizapp.services.Teacher.TeacherHimSelfServices.MyTeacherService;
import com.team3d.quiz.quizapp.services.Teacher.TeacherHimSelfServices.MyTeacherServiceImplementation;
import com.team3d.quiz.quizapp.services.Teacher.TeacherService;
import com.team3d.quiz.quizapp.services.Teacher.TeacherServiceImplementation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImplementation implements QuestionService{

    private MyTeacherService teacherService;
    private QuestionRepository questionRepository;



    public QuestionServiceImplementation(MyTeacherServiceImplementation teacherService, QuestionRepository questionRepository) {
        this.teacherService = teacherService;
        this.questionRepository = questionRepository;
    }

    @Override
    public void addQuestionByTeacher(QuestionDTOForAdd dtoForAdd) {

        List<Choice> choices = new ArrayList<>();
        for (String ch:dtoForAdd.getCorrect()){
            choices.add(new Choice(ch.trim(),true));
        }
        for (String ch:dtoForAdd.getIncorrect()){
            choices.add(new Choice(ch.trim(),false));
        }
        MultiChoiseQuestion multiChoiseQuestion = new MultiChoiseQuestion();
        multiChoiseQuestion.setQuestion(dtoForAdd.getTitle());
        multiChoiseQuestion.setChoices(choices);
        multiChoiseQuestion.setTeacher(teacherService.getTeacherById(teacherService.getCurrentTeacher()));

        questionRepository.save(multiChoiseQuestion);

    }
}
