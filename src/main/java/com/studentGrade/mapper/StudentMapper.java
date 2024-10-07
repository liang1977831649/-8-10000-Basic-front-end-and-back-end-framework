package com.studentGrade.mapper;

import com.studentGrade.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {

    @Select("select * from student where id=#{id}")
    public Student queryStudentById(Student student);

    @Update("update student set password=#{password} where id=#{id}")
    public void updateStudentPassword(Student student);
}
