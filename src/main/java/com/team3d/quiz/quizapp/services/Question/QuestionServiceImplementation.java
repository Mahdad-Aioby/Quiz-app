package com.team3d.quiz.quizapp.services.Question;

import com.team3d.quiz.quizapp.entities.CourseQuiz;
import com.team3d.quiz.quizapp.entities.QuestionEntities.Choice;
import com.team3d.quiz.quizapp.entities.QuestionEntities.MultiChoiseQuestion;
import com.team3d.quiz.quizapp.entities.dto.QuestionDTOForAdd;
import com.team3d.quiz.quizapp.repositories.Question.QuestionRepository;
import com.team3d.quiz.quizapp.services.Quiz.QuizService;
import com.team3d.quiz.quizapp.services.Quiz.QuizServiceImplementation;
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
    private QuizService quizService;



    public QuestionServiceImplementation(MyTeacherServiceImplementation teacherService, QuestionRepository questionRepository , QuizServiceImplementation quizService) {
        this.teacherService = teacherService;
        this.questionRepository = questionRepository;
        this.quizService =quizService;
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
        CourseQuiz courseQuiz= quizService.getQuizById(dtoForAdd.getCid());

        MultiChoiseQuestion question = questionRepository.save(multiChoiseQuestion);
        List<MultiChoiseQuestion> multiChoiseQuestions = courseQuiz.getMultiChoiseQuestions();
        multiChoiseQuestions.add(question);
        courseQuiz.setMultiChoiseQuestions(multiChoiseQuestions);
        quizService.update(courseQuiz);


    }
}
