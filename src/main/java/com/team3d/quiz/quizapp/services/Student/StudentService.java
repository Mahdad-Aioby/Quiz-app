package com.team3d.quiz.quizapp.services.Student;

import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.repositories.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {

    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentService() {

    }

    public List<Student> students(Student filter) {

        List<Student> students = studentRepository.findAll((Specification<Student>) (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            // If designation is specified in filter, add equal where clause
            if (filter.getFirstname() != null) {
                predicates.add(cb.equal(root.get("firstname"), filter.getFirstname()));
            }

//            // If firstName is specified in filter, add contains (lile)
//            // filter to where clause with ignore case
//            if (filter.getLastname() != null) {
//                predicates.add(cb.like(cb.lower(root.get("lastname")),
//                        "%" + filter.getLastname().toLowerCase() + "%"));
//            }
//
//            // If lastName is specified in filter, add contains (lile)
//            // filter to where clause with ignore case
//            if (filter.getNationalcode() != null) {
//                predicates.add(cb.like(cb.lower(root.get("nationalcode")),
//                        "%" + filter.getNationalcode().toLowerCase() + "%"));
//            }

            return cb.and(predicates.toArray(new Predicate[0]));
        });
       return students;

    }


}
