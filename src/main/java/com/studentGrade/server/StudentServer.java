package com.studentGrade.server;

import com.studentGrade.entity.Student;

public interface StudentServer {
    public Student queryStudentById(Student student);
    public void  updatePasswordByStudentId(Student student);
}
