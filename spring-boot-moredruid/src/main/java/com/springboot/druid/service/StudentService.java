package com.springboot.druid.service;


import com.springboot.druid.entities.Student;

import java.util.List;

public interface StudentService {

    public boolean createUser(Student student);

    public List<Student> getByPage(int page, int rows);
}
