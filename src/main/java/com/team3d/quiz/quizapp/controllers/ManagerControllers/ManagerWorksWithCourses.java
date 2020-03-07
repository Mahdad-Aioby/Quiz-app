package com.team3d.quiz.quizapp.controllers.ManagerControllers;


import com.team3d.quiz.quizapp.entities.Course;
import com.team3d.quiz.quizapp.entities.dto.CourseDTO;
import com.team3d.quiz.quizapp.entities.dto.ListCourseDTO;
import com.team3d.quiz.quizapp.services.Course.CourseService;
import com.team3d.quiz.quizapp.services.Course.CourseServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/Courses")
public class ManagerWorksWithCourses {

    private CourseService courseService;

    @Autowired
    public ManagerWorksWithCourses(CourseServiceImplementation courseService) {
        this.courseService = courseService;
    }

    @PostMapping( value = "/Create")
    public void createCourse(@RequestBody CourseDTO course){

        courseService.addCourse(course);

    }

    @PostMapping(value = "/get-all-courses")
    private List<ListCourseDTO> getAllCourses(){
        return courseService.getAllCourses();

    }

    @PostMapping(value = "/delete-course")
    private void delete(@RequestBody Long courseId){
        courseService.deleteCourse(courseId);
    }


    @PostMapping("/get-course")
    private Course getCourse(@RequestBody Long courseId){
       Course course= courseService.getCourseById(courseId).get();

       return course;
    }

}
