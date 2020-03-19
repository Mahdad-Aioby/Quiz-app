package com.team3d.quiz.quizapp.services.Question;

import com.team3d.quiz.quizapp.entities.dto.GetTeachersQuestions;
import com.team3d.quiz.quizapp.entities.dto.QuestionDTOForAdd;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    void addQuestionByTeacher(QuestionDTOForAdd dtoForAdd);

    List<GetTeachersQuestions> QUESTIONS();
}
