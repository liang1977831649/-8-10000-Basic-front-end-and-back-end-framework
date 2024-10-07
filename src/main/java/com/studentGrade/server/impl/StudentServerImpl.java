package com.studentGrade.server.impl;

import com.studentGrade.entity.Student;
import com.studentGrade.mapper.StudentMapper;
import com.studentGrade.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServerImpl implements StudentServer {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Student student) {
        return studentMapper.queryStudentById(student);
    }

    @Override
    public void updatePasswordByStudentId(Student student) {
        studentMapper.updateStudentPassword(student);
    }
}
