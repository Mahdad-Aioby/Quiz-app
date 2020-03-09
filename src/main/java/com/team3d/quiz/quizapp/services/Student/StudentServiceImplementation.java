package com.team3d.quiz.quizapp.services.Student;


import com.team3d.quiz.quizapp.entities.Course;
import com.team3d.quiz.quizapp.entities.Student;
import com.team3d.quiz.quizapp.entities.dto.ListStudentDTOForCourses;
import com.team3d.quiz.quizapp.entities.dto.ListTeacherDTOForCourses;
import com.team3d.quiz.quizapp.repositories.Student.StudentRepository;
import com.team3d.quiz.quizapp.services.Course.CourseService;
import com.team3d.quiz.quizapp.services.Course.CourseServiceImplementation;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.CollectionCertStoreParameters;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements StudentService {

    private StudentRepository studentRepository;
    private CourseService courseService;



    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository, CourseServiceImplementation courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }



    @Override
    public List<ListStudentDTOForCourses> students() {
        return studentRepository.findAll().stream().filter(student -> student.getAccount().isActive()).map(student -> new ListStudentDTOForCourses(student.getId(),student.getFirstname(),student.getLastname())).collect(Collectors.toList());
    }

    @Override
    public void addStudentToCourse(List<Long> longs) {
        Optional<Course> course = courseService.getCourseById(longs.get(0));
        Optional<Student> student = studentRepository.findById(longs.get(1));
        Student stu = student.get();
        Set<Course> courses;
        courses = stu.getCourses().stream().collect(Collectors.toSet());
        courses.add(course.get());
        stu.setCourses(courses);
        studentRepository.save(stu);
    }
}
