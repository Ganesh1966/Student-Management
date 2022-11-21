package com.example.student.system.Controller;

import com.example.student.system.Entity.Address;
import com.example.student.system.Entity.Student;
import com.example.student.system.Exceptions.ResourceNotFoundException;
import com.example.student.system.Exceptions.ServerException;
import com.example.student.system.Repository.StudentRepository;
import com.example.student.system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student){

        Student saveStudents = studentService.saveStudents(student);

        return new ResponseEntity<Student>(saveStudents, HttpStatus.CREATED);
    }

    @PostMapping("addAddress")
    public ResponseEntity<Address> saveAddressHandler(@RequestBody Address address){
        Address saveAddress = studentService.saveAddress(address);
        return new ResponseEntity<Address>(saveAddress,HttpStatus.CREATED);
    }

    @GetMapping("/Student/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable("name") String name){

        Student studentList = studentService.getStudentByName(name);
        return  new ResponseEntity<Student>(studentList,HttpStatus.OK);
    }

    @GetMapping("getstudent/course/{course_id}")
    public ResponseEntity<List<Student>> getStudentById(@PathVariable("course_id") Long course_id){

        List<Student> studentList = studentService.getStudentById(course_id);
        return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);

    }

    @PutMapping("updateStudent/{id}")
    public ResponseEntity<Student> update(@PathVariable long id, @RequestBody Student student) {

       Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));

        updateStudent.setName(student.getName());
        updateStudent.setCourse(student.getCourse());
        updateStudent.setAddress1(student.getAddress1());
        updateStudent.setDate_of_birth(student.getDate_of_birth());
        studentRepository.save(updateStudent);

        if (student == null) {
            throw new ServerException();
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @DeleteMapping("/course/id/st_id")
    public HttpStatus deletecourse(@PathVariable long id,@PathVariable long st_id) {

        try {
            studentService.LeaveCourseById(id,st_id);
            return HttpStatus.OK;
        }
        catch (Exception e) {
            throw new ResourceNotFoundException("Student not exist with id: " + id);
        }
    }






}
