package com.firstapp.sample.service;

import com.firstapp.sample.bean.Course;
import com.firstapp.sample.bean.Student;
import com.firstapp.sample.repository.CourseRepository;
import com.firstapp.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    private EmailServiceImpl emailService;

    public Iterable<Course> getCourse() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String id) {
        Optional<Course> courses = Optional.ofNullable(courseRepository.findById(Integer.parseInt(id)).orElse(null));
        return courses.get();
    }

    public List<Course> getCoursesById(String id) {
        return courseRepository.findCourseByStudentId(id);
    }

    public Course getCourseByParam(String id) {
        Optional<Course> course = Optional.ofNullable(courseRepository.findById(Integer.parseInt(id)).orElse(null));
        return course.get();
    }

    public String saveCourse(Course course) {
        courseRepository.save(course);
        return "course";
    }

    public void save(String id, Course course) {
        Student student = Optional.of(studentRepository.findById(id).orElse(null)).get();
        course.setStudent(student);
        this.courseRepository.save(course);
    }

    public Course updateCourse(String id, Course course) {
        Optional<Course> cour = courseRepository.findById(Integer.parseInt(id));
        if(cour == null) {
            return null;
        }
        return this.courseRepository.save(course);
    }

    public String removeCourse(String s_id, String id) {
        courseRepository.disEnrollCoursesByStudentId(s_id, Integer.parseInt(id));
        return "Disenrolled";
    }

    public void deleteCourse(String id) {
        this.courseRepository.deleteById(Integer.parseInt(id));
    }
}
