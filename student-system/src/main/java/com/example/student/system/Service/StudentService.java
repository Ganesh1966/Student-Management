package com.example.student.system.Service;

import com.example.student.system.Entity.Address;
import com.example.student.system.Entity.Course_Student;
import com.example.student.system.Entity.Student;
import com.example.student.system.Repository.AddressRepository;
import com.example.student.system.Repository.StudentRepository;
import com.example.student.system.Repository.Student_CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    Student_CourseRepository student_courseRepository;

    public Address saveAddress(Address address) {
        Address address1=addressRepository.save(address);
        return address1;
    }

    public Student saveStudents(Student student) {

        Student student1=studentRepository.save(student);
        return student1;
    }

    public Student getStudentByName(String name) {
        Student student=studentRepository.getStudentByName(name);
        return studentRepository.getStudentByName(student.getName());
    }

    public List<Student> getStudentById(Long course_id) {
        List<Course_Student> course_student= student_courseRepository.getStudentById(course_id);
        List<Student> st=new ArrayList<>();
        for(Course_Student course_student1:course_student){
            st.add(studentRepository.getStudentById(course_student1.getStudent_id()));
        }
        return st;
    }

    public Student updateStudentRecord(Student updatedStudent) {
        return studentRepository.save(updatedStudent);

    }
    public void LeaveCourseById(Long student_id,Long course_id){

        Course_Student course_student= student_courseRepository.getCourse_StudentBy(student_id,course_id);
        student_courseRepository.delete(course_student);

    }
}
