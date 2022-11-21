package com.example.student.system.Controller;

import com.example.student.system.Entity.Course;
import com.example.student.system.Entity.Course_Student;
import com.example.student.system.Entity.Student;
import com.example.student.system.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<Course> saveCourseHandler(@RequestBody Course course){

        Course saveCourse=courseService.saveCorses(course);

        return new ResponseEntity<Course>(saveCourse, HttpStatus.CREATED);
    }

    @PostMapping("addCourse/Student")
    public ResponseEntity<Course_Student> addCourseToStudent(@RequestBody Course_Student course_student){
        Course_Student savecourse_student=courseService.addCourse_student(course_student);
        return new ResponseEntity<Course_Student>(savecourse_student,HttpStatus.CREATED);

    }


}
