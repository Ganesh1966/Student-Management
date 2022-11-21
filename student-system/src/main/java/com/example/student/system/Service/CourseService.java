package com.example.student.system.Service;

import com.example.student.system.Entity.Course;
import com.example.student.system.Entity.Course_Student;
import com.example.student.system.Repository.CourseRepository;
import com.example.student.system.Repository.Student_CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    Student_CourseRepository student_courseRepository;

    public Course saveCorses(Course course) {

        Course course1=courseRepository.save(course);
        return course1;
    }

    public Course_Student addCourse_student(Course_Student course_student) {
        Course_Student course_student1=student_courseRepository.save(course_student);
        return course_student1;
    }
}
