package com.firstapp.sample.controller;

import com.firstapp.sample.bean.Student;
import com.firstapp.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/student")
    public String saveStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/student/{s_id}")
    public Student getStudent(@PathVariable String s_id) {
        return studentService.getStudent(s_id);
    }

    @PutMapping("/student/{s_id}/course/{id}")
    public String enroll(@PathVariable String s_id, @PathVariable String id) {
        return studentService.enrollCourse(s_id, id);
    }

    @DeleteMapping("/student/{s_id}")
    public void deleteStudent(@PathVariable String s_id) {
        studentService.delete(s_id);
    }
}
