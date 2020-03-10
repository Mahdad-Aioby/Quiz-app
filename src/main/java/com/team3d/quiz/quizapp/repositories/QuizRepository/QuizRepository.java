package com.team3d.quiz.quizapp.repositories.QuizRepository;


import com.team3d.quiz.quizapp.entities.Course;
import com.team3d.quiz.quizapp.entities.CourseQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<CourseQuiz,Long> {

    List<CourseQuiz> findCourseQuizByCourse(Course course);

    @Modifying
    @Transactional
    @Query(value = "update quiz q set q.quiz_title = :title, q.quiz_desc = :description , q.quiz_time = :time where q.id = :id",nativeQuery = true)
    void updateQuiz(@Param("title") String title,@Param("description") String desc,@Param("time") double time,@Param("id") Long id);

    void deleteById(Long id);
}
