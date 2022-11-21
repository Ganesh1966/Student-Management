package com.example.student.system.Repository;

import com.example.student.system.Entity.Course_Student;
import com.example.student.system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student_CourseRepository extends JpaRepository<Course_Student, Long> {

    public List<Course_Student> getStudentById(Long course_id);

    public Course_Student getCourse_StudentBy(Long student_id,Long course_id);
}
