package com.team3d.quiz.quizapp.services.Course;

import com.team3d.quiz.quizapp.entities.Course;
import com.team3d.quiz.quizapp.entities.dto.CourseDTO;
import com.team3d.quiz.quizapp.entities.dto.ListCourseDTO;
import com.team3d.quiz.quizapp.repositories.Course.CourseRepository;
import com.team3d.quiz.quizapp.util.MyDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImplementation implements CourseService {

    private CourseRepository courseRepository;
    @Autowired
    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void addCourse(CourseDTO courseDTO) {
        Course course = new Course();

        Date startDate = MyDate.changeFromJalali(courseDTO.getStartDate());
        Date endDate = MyDate.changeFromJalali(courseDTO.getEndDate());

        course.setStartDate(startDate);
        course.setEndDate(endDate);
        course.setCourseTitle(courseDTO.getCourseTitle());
        course.setCourseDesc(courseDTO.getCourseDesc());
        course.setStatus(courseDTO.getStatus());

        courseRepository.save(course);
    }

    @Override
    public List<ListCourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();

        return courses.stream().map(course -> new ListCourseDTO(course.getId(),course.getStudents(),course.getTeacher(),MyDate.changeFromGeorgian(course.getStartDate()),MyDate.changeFromGeorgian(course.getEndDate()),course.getStatus(),course.getCourseTitle(),course.getCourseDesc())).collect(Collectors.toList());
    }

    public void deleteCourse(Long id){
        Optional<Course> course = courseRepository.findById(id);

        courseRepository.delete(course.get());
    }

    @Override
    public Optional<Course> getCourseById(Long courseId) {
        Optional<Course> course= courseRepository.findById(courseId);
        return course;
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void update(CourseDTO courseDTO) {
        Course course = courseRepository.getOne(courseDTO.getId());
        Date startDate = MyDate.changeFromJalali(courseDTO.getStartDate());
        Date endDate = MyDate.changeFromJalali(courseDTO.getEndDate());
        course.setStartDate(startDate);
        course.setEndDate(endDate);
        course.setCourseTitle(courseDTO.getCourseTitle());
        course.setCourseDesc(courseDTO.getCourseDesc());
        course.setStatus(courseDTO.getStatus());
        course.setId(courseDTO.getId());
        courseRepository.save(course);
    }


}
