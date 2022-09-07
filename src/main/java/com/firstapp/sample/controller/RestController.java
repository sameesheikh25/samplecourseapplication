package com.firstapp.sample.controller;

import com.firstapp.sample.bean.Course;
import com.firstapp.sample.bean.NewCourse;
import com.firstapp.sample.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    CourseService courseService;

    @GetMapping("/")
    public String getResponse() {
        return "Hello!";
    }

    @GetMapping(value = {"/course", "/course/{id}"})
    public Iterable<Course> getCourse(@PathVariable Map<String, String> params) {
        String id = params.get("id");
        List<Course> courses = new ArrayList<Course>();
        if(id != null) {
            courses.add(courseService.getCourseById(id));
            return courses;
        }
        return courseService.getCourse();
    }

//    @GetMapping("/course/{id}")
//    public Course getCourseById(@PathVariable String id) {
//        return courseService.getCourseById(id);
//    }

    @GetMapping("/course/")
    public Course getCourseByQuery(@RequestParam String id) {
        return courseService.getCourseByParam(id);
    }

    @GetMapping("/student/{id}/course")
    public List<Course> getCoursesByStudId(@PathVariable String id) {
        return courseService.getCoursesById(id);
    }

    @PostMapping("/course")
    public String saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PostMapping("student/{id}/course")
    public String createCourse(@PathVariable String id, @RequestBody Course course) {
        courseService.save(id, course);
        return "course";
    }

    @PutMapping("/course/{id}")
    @ResponseBody
    public Course updateCourse(@PathVariable String id,@RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/course")
    public void deleteCourse(@Validated @RequestParam("id") String courseId) {
        courseService.deleteCourse(courseId);
    }

    @DeleteMapping("/student/{s_id}/course/{id}")
    public String disenroll(@PathVariable String s_id, @PathVariable String id) {
        return courseService.removeCourse(s_id, id);
    }
}
