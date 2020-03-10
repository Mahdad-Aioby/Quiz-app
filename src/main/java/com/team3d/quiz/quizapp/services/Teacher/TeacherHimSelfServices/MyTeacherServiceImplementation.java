package com.team3d.quiz.quizapp.services.Teacher.TeacherHimSelfServices;


import com.team3d.quiz.quizapp.entities.Account;
import com.team3d.quiz.quizapp.entities.Teacher;
import com.team3d.quiz.quizapp.entities.dto.ListCourseDTO;
import com.team3d.quiz.quizapp.repositories.TeacherRepository;
import com.team3d.quiz.quizapp.services.AccountService;
import com.team3d.quiz.quizapp.util.MyDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyTeacherServiceImplementation implements MyTeacherService {

    private TeacherRepository teacherRepository;
    private AccountService accountService;

    @Autowired
    public MyTeacherServiceImplementation(TeacherRepository teacherRepository, AccountService accountService) {
        this.teacherRepository = teacherRepository;
        this.accountService = accountService;
    }

    @Override
    public List<ListCourseDTO> showMyCourses(Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if(teacher.isPresent()){
           return teacher.get().getCourses().stream().map(course -> new ListCourseDTO(course.getId(),course.getStudents(),course.getTeacher(), MyDate.changeFromGeorgian(course.getStartDate()),MyDate.changeFromGeorgian(course.getEndDate()),course.getStatus(),course.getCourseTitle(),course.getCourseDesc())).collect(Collectors.toList());

        }

        return null;
    }

    public Long getCurrentTeacher(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        Account account = accountService.getAccountByUserName(currentUserName);
        List<Teacher> teacher = teacherRepository.findAll().stream().filter(t->t.getAccount().getId()==account.getId()).collect(Collectors.toList());
        System.out.println("got t id");
        return teacher.get(0).getId();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }
}
