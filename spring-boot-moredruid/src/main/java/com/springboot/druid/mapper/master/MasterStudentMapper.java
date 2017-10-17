package com.springboot.druid.mapper.master;

import com.springboot.druid.entities.Student;

import java.util.List;

public interface MasterStudentMapper {

    int insert(Student student);

    List<Student> getBypage();
}
