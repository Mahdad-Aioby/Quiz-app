package com.team3d.quiz.quizapp.repositories;

import com.team3d.quiz.quizapp.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    List<Teacher> findAllByAccountNotNull();
}
