package com.team3d.quiz.quizapp.services.Quiz;

import com.team3d.quiz.quizapp.entities.CourseQuiz;
import com.team3d.quiz.quizapp.entities.Teacher;
import com.team3d.quiz.quizapp.entities.dto.QuizDTOForCreate;
import com.team3d.quiz.quizapp.entities.dto.QuizDTOforShow;
import com.team3d.quiz.quizapp.repositories.QuizRepository.QuizRepository;
import com.team3d.quiz.quizapp.services.Course.CourseService;
import com.team3d.quiz.quizapp.services.Course.CourseServiceImplementation;
import com.team3d.quiz.quizapp.services.Teacher.TeacherHimSelfServices.MyTeacherService;
import com.team3d.quiz.quizapp.services.Teacher.TeacherHimSelfServices.MyTeacherServiceImplementation;
import com.team3d.quiz.quizapp.services.Teacher.TeacherService;
import com.team3d.quiz.quizapp.services.Teacher.TeacherServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImplementation implements QuizService {

    private QuizRepository quizRepository;
    private MyTeacherService myTeacherService;
    private CourseService courseService;

    @Autowired
    public QuizServiceImplementation(QuizRepository quizRepository, MyTeacherServiceImplementation myTeacherService, CourseServiceImplementation courseServiceImplementation) {
        this.quizRepository = quizRepository;
        this.myTeacherService = myTeacherService;
        this.courseService = courseServiceImplementation;
    }

    @Override
    public void addQuiz(QuizDTOForCreate quizDTOForCreate) {
        Long cid = myTeacherService.getCurrentTeacher();

        quizRepository.save(new CourseQuiz(
                quizDTOForCreate.getTitle(),
                quizDTOForCreate.getDesc(),
                quizDTOForCreate.getTime(),
                courseService.getCourseById(quizDTOForCreate.getCid()).get(),
                myTeacherService.getTeacherById(cid)
        ));
    }

    @Override
    public List<QuizDTOforShow> getAllCoursesById(Long courseId) {

        return quizRepository.findCourseQuizByCourse(courseService.getCourseById(courseId).get()).stream().map(courseQuiz -> new QuizDTOforShow(courseQuiz.getId(),courseQuiz.getQuizTitle(),courseQuiz.getQuizDesc(),courseQuiz.getQuizTime())).collect(Collectors.toList());

    }

    @Override
    public void update(QuizDTOforShow quizDTOforShow) {

        quizRepository.updateQuiz(quizDTOforShow.getTitle(),quizDTOforShow.getDesc(),quizDTOforShow.getTime(),quizDTOforShow.getId());
    }

    @Override
    public void delete(Long qid) {
        quizRepository.deleteById(qid);
    }

    @Override
    public List<QuizDTOforShow> getAllOfMyQuiz() {
        Long tid = myTeacherService.getCurrentTeacher();
        Teacher teacher = myTeacherService.getTeacherById(tid);
        return quizRepository.findCourseQuizByTeacher(teacher).stream().map(courseQuiz -> new QuizDTOforShow(courseQuiz.getId(),courseQuiz.getQuizTitle(),courseQuiz.getQuizDesc(),courseQuiz.getQuizTime())).collect(Collectors.toList());
    }

    @Override
    public CourseQuiz getQuizById(Long id) {
        return quizRepository.findById(id).get();
    }

    @Override
    public void update(CourseQuiz courseQuiz) {
        quizRepository.saveAndFlush(courseQuiz);
    }
}
