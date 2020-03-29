package com.team3d.quiz.quizapp.repositories.Question;

import com.team3d.quiz.quizapp.entities.QuestionEntities.MultiChoiseQuestion;
import com.team3d.quiz.quizapp.entities.Teacher;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<MultiChoiseQuestion,Long> {

    List<MultiChoiseQuestion> findAllByTeacher(Teacher teacher);

    @Modifying
    @Transactional
    @Query(value = "update multi_choise_question q set q.question = :question where q.id = :id",nativeQuery = true)
    void updateQuestion(@Param("question") String question, @Param("id") Long id);

}
