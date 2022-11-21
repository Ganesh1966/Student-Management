package com.example.student.system.Controller;

import com.example.student.system.Entity.Address;
import com.example.student.system.Entity.Student;
import com.example.student.system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

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





}
