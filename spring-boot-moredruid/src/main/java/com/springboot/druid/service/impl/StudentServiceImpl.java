package com.springboot.druid.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.druid.annotation.TargetDataSource;
import com.springboot.druid.entities.Student;
import com.springboot.druid.mapper.cluster.ClusterStudentMapper;
import com.springboot.druid.mapper.master.MasterStudentMapper;
import com.springboot.druid.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private MasterStudentMapper masterStudentMapper;

    @Autowired
    private ClusterStudentMapper clusterStudentMapper;

    @Override
    @Transactional
    @TargetDataSource(dataSource = "masterDataSource")
    public boolean createUser(Student student) {
        boolean flag = false;
        int insert = masterStudentMapper.insert(student);
        if(insert > 0){
            flag = true;
        }
        return flag;
    }

    @Override
    @TargetDataSource(dataSource = "cluster1DataSource")
    public List<Student> getByPage(int page, int rows) {
        Page<Student> studentPage = PageHelper.startPage(page, rows, true);
        List<Student> students = clusterStudentMapper.getBypage();
        System.out.println("-------------------" + studentPage.toString() + "-----------");
        return students;
    }
}
