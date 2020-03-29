package com.team3d.quiz.quizapp.controllers.StudentControllers;

import com.team3d.quiz.quizapp.entities.dto.studentdtos.CourseDTOForStudent;
import com.team3d.quiz.quizapp.services.Student.StudentSelf.StudentSelfService;
import com.team3d.quiz.quizapp.services.Student.StudentSelf.StudentSelfServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/Student",method = RequestMethod.POST)
public class StudentWorksWithCourses {

    private StudentSelfService studentSelfService;

    @Autowired
    public StudentWorksWithCourses(StudentSelfServiceImplementation studentService) {
        this.studentSelfService = studentService;
    }

    @PostMapping("/get-courses-im-in")

   private Set<CourseDTOForStudent> getAllCourses(){


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        return studentSelfService.studentCourses(currentUserName);
   }

}
