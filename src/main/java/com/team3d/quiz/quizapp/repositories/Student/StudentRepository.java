package com.team3d.quiz.quizapp.repositories.Student;

import com.team3d.quiz.quizapp.entities.Course;
import com.team3d.quiz.quizapp.entities.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {


    Student getStudentByAccount_Username(String username);
}
