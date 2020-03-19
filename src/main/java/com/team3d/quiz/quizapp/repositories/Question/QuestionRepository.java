package com.team3d.quiz.quizapp.repositories.Question;

import com.team3d.quiz.quizapp.entities.QuestionEntities.MultiChoiseQuestion;
import com.team3d.quiz.quizapp.entities.Teacher;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<MultiChoiseQuestion,Long> {

    List<MultiChoiseQuestion> findAllByTeacher(Teacher teacher);
}
