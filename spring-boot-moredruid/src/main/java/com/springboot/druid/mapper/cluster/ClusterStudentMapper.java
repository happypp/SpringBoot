package com.springboot.druid.mapper.cluster;

import com.springboot.druid.entities.Student;

import java.util.List;

public interface ClusterStudentMapper {

    int insert(Student student);

    List<Student> getBypage();
}
