package com.team3d.quiz.quizapp.services.Question;

import com.team3d.quiz.quizapp.entities.dto.QuestionDTOForAdd;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {

    void addQuestionByTeacher(QuestionDTOForAdd dtoForAdd);
}
