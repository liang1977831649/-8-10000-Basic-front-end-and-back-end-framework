package com.studentGrade.intercepter;

import com.auth0.jwt.JWT;
import com.studentGrade.utils.JwtUtil;
import com.studentGrade.utils.ThreadLocalUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //String token = request.getHeader("Authorization");
        //
        //Map<String, Object> stringObjectMap = null;
        //try {
        //    stringObjectMap = JwtUtil.parseToken(token);
        //    String redisToken = redisTemplate.opsForValue().get("token" + stringObjectMap.get("id"));
        //    if(!redisToken.equals(token)){
        //        response.setStatus(401);
        //        return false;
        //    }
        //
        //    ThreadLocalUtils.set(stringObjectMap);
        //} catch (Exception e) {
        //    response.setStatus(401);
        //    e.printStackTrace();
        //    return false;
        //}


        return  true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
