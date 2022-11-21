package com.example.student.system.Repository;

import com.example.student.system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student getStudentByName(String name);

    public Student getStudentById(Long id);


}
