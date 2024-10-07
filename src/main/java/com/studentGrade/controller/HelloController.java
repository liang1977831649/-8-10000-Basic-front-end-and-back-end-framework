package com.studentGrade.controller;

import com.studentGrade.utils.ThreadLocalUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello方法已被访问");
        //HashMap<String,Object> hashMap = ThreadLocalUtils.get();
        //Iterator<Map.Entry<String, Object>> iterator = hashMap.entrySet().iterator();
        //while (iterator.hasNext()){
        //    Map.Entry<String, Object> next = iterator.next();
        //    System.out.println( next.getKey()+"=="+next.getValue());
        //}
        return "hello,Controller";
    }

}
