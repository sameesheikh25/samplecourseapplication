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
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EmailServiceImpl emailService;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public String createStudent(Student student) {
        studentRepository.save(student);
        return "student";
    }

    public Student getStudent(String s_id) {
        return Optional.ofNullable(studentRepository.findById(s_id).orElse(null)).get();
    }

    public String enrollCourse(String s_id, String id) {
        Course course = Optional.of(courseRepository.findById(Integer.parseInt(id)).orElse(null)).get();
        Student student = this.getStudent(s_id);
        course.setStudent(student);
        courseRepository.save(course);
//        this.emailService.sendEmail(student.getEmail(), "Enrolled Successful", "Thanks for Registering");
        return "enrolled";
    }

    public void delete(String s_id) {
        studentRepository.deleteById(s_id);
    }
}
