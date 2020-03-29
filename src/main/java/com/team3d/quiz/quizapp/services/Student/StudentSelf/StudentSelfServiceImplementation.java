package com.team3d.quiz.quizapp.services.Student.StudentSelf;

import com.team3d.quiz.quizapp.entities.dto.studentdtos.ChoiceDTOForStudent;
import com.team3d.quiz.quizapp.entities.dto.studentdtos.CourseDTOForStudent;
import com.team3d.quiz.quizapp.entities.dto.studentdtos.CourseQuizDTOforStudent;
import com.team3d.quiz.quizapp.entities.dto.studentdtos.QuestionDTOforStudent;
import com.team3d.quiz.quizapp.repositories.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentSelfServiceImplementation implements StudentSelfService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentSelfServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<CourseDTOForStudent> studentCourses(String username) {
        return studentRepository.findById(this.getByUsername(username)).get().getCourses()
                .stream()
                .map(course -> new CourseDTOForStudent(course.getId(),course.getCourseTitle(),course.getCourseQuizs()
                        .stream()
                        .map(courseQuiz -> new CourseQuizDTOforStudent(
                                courseQuiz.getQuizTitle(),
                                courseQuiz.getQuizDesc(),
                                courseQuiz.getQuizTime(),
                                courseQuiz.getMultiChoiseQuestions()
                                        .stream()
                                        .map(multiChoiseQuestion -> new QuestionDTOforStudent(
                                                multiChoiseQuestion.getId(),
                                                multiChoiseQuestion.getQuestion(),
                                                multiChoiseQuestion.getChoices()
                                                        .stream()
                                                        .map(choice -> new ChoiceDTOForStudent(
                                                                choice.getId(),
                                                                choice.getTitle(),
                                                                choice.isCurrect()))
                                                        .collect(Collectors.toList())))
                                        .collect(Collectors.toList())))
                        .collect(Collectors.toList())))
                .collect(Collectors.toSet());
    }

    @Override
    public Long getByUsername(String username) {
        return studentRepository.getStudentByAccount_Username(username).getId();
    }
}
