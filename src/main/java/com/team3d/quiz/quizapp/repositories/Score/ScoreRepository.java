package com.team3d.quiz.quizapp.repositories.Score;

import com.team3d.quiz.quizapp.entities.QuestionEntities.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score,Long> {

}
