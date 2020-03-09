package com.team3d.quiz.quizapp.services.Teacher;

import com.team3d.quiz.quizapp.entities.Course;
import com.team3d.quiz.quizapp.entities.Teacher;
import com.team3d.quiz.quizapp.entities.dto.ListTeacherDTOForCourses;
import com.team3d.quiz.quizapp.repositories.Course.CourseRepository;
import com.team3d.quiz.quizapp.repositories.TeacherRepository;
import com.team3d.quiz.quizapp.services.Course.CourseService;
import com.team3d.quiz.quizapp.services.Course.CourseServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImplementation implements TeacherService {

    private TeacherRepository teacherRepository;
    private CourseService courseService;

    @Autowired
    public TeacherServiceImplementation(TeacherRepository teacherRepository, CourseServiceImplementation courseServiceImplementation) {
        this.teacherRepository = teacherRepository;
        this.courseService = courseServiceImplementation;
    }

    @Override
    public List<ListTeacherDTOForCourses> Teachers() {

        List<ListTeacherDTOForCourses> listTeacherDTOForCourses=
                teacherRepository.findAllByAccountNotNull().stream().filter(teacher ->
                teacher.getAccount().isActive()).map(teacher -> new ListTeacherDTOForCourses(teacher.getId(),teacher.getFirstname(),teacher.getLastname())).collect(Collectors.toList());

        return listTeacherDTOForCourses;
    }

    @Override
    public void addTeacherToCourse(List<Long> longs) {
        Optional<Course> course = courseService.getCourseById(longs.get(0));
        Optional<Teacher> teacher = teacherRepository.findById(longs.get(1));
        course.ifPresent(myc->myc.setTeacher(teacher.get()));
        courseService.update(course.get());
    }



}
