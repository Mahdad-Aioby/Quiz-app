package com.team3d.quiz.quizapp.services.Student;

import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.entities.dto.ListStudentDTOForCourses;
import com.team3d.quiz.quizapp.repositories.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@Service
public interface StudentService {

    List<ListStudentDTOForCourses> students();

    void addStudentToCourse(List<Long> longs);



}
