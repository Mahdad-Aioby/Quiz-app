package com.team3d.quiz.quizapp.services.Question;

import com.team3d.quiz.quizapp.entities.QuestionEntities.MultiChoiseQuestion;
import com.team3d.quiz.quizapp.entities.QuestionEntities.Question;
import com.team3d.quiz.quizapp.entities.dto.EditSelfQuestionDTO;
import com.team3d.quiz.quizapp.entities.dto.GetTeachersQuestions;
import com.team3d.quiz.quizapp.entities.dto.QuestionDTOForAdd;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    void addQuestionByTeacher(QuestionDTOForAdd dtoForAdd);

    List<GetTeachersQuestions> QUESTIONS();

    void updateQuestionItSelf(EditSelfQuestionDTO editSelfQuestionDTO);

    MultiChoiseQuestion getQuestionById(Long questionId);
}
