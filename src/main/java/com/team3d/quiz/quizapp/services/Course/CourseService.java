package com.team3d.quiz.quizapp.services.Course;

import com.team3d.quiz.quizapp.entities.Course;
import com.team3d.quiz.quizapp.entities.dto.CourseDTO;
import com.team3d.quiz.quizapp.entities.dto.ListCourseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    void addCourse(CourseDTO courseDTO);

    List<ListCourseDTO> getAllCourses();

    void deleteCourse(Long id);

    Optional<Course> getCourseById(Long courseId);

    void update(Course course);
}
