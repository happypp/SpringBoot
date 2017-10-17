package com.springboot.druid.controller;

import com.springboot.druid.entities.Student;
import com.springboot.druid.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("createStudent")
    public boolean createStudet(){
        Student student = new Student();
        student.setName("张三");
        student.setAge(16);
        return studentService.createUser(student);
    }


    @GetMapping("getStudent")
    public void getStudents(){
        List<Student> students = studentService.getByPage(0, 10);
        System.out.println(students);
    }
}
