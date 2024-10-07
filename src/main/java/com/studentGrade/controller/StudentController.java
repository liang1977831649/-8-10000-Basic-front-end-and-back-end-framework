package com.studentGrade.controller;


import com.studentGrade.entity.Result;
import com.studentGrade.entity.Student;
import com.studentGrade.server.StudentServer;
import com.studentGrade.utils.JwtUtil;
import com.studentGrade.utils.Md5Util;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServer studentServer;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/login")
    public Result login( Student student){
        System.out.println("student="+student);
        if(student==null){
            return Result.error("没有该学生");
        }
        if(student.getId()==null||StringUtil.isNullOrEmpty(student.getPassword())){
            return Result.error("没有完整的账号和密码");
        }
        Student studentById = studentServer.queryStudentById(student);
        //加密再对比
        student.setPassword(Md5Util.getMD5String(student.getPassword()));
        //如果不相等
        if(!studentById.getPassword().equals(student.getPassword())){
            return Result.error("密码错误");
        }
        //使用JWT工具加密
        //HashMap<String, Object> hashMap = new HashMap<>();
        //hashMap.put("id",studentById.getId());
        //String token = JwtUtil.getToken(hashMap);

        //存入到redis中
        //redisTemplate.opsForValue().set("token"+studentById.getId(),token,1,TimeUnit.HOURS);
        //return Result.success(token);
        return Result.success();
    }

}
