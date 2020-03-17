package com.team3d.quiz.quizapp.repositories.Question;

import com.team3d.quiz.quizapp.entities.QuestionEntities.MultiChoiseQuestion;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<MultiChoiseQuestion,Long> {
}
