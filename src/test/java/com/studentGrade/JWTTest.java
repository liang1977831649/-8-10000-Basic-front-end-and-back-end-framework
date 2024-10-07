package com.studentGrade;

import com.studentGrade.utils.JwtUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JWTTest {
    @Test
    public void jwt(){
        String str="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsiaWQiOjIsInVzZXJuYW1lIjoic21pdGgifSwiZXhwIjoxNzI1MjE3MTE0fQ.FxK9C-MAe9rPYhMAaGgZTYVXnzbwk6fkKM2IdZkeOek";
        Map<String, Object> stringObjectMap = JwtUtil.parseToken(str);
        System.out.println(stringObjectMap);
    }
}
