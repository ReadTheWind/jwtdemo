package com.learn.jwtdemo.interceptor;

import com.learn.jwtdemo.annotation.JwtIgnore;
import com.learn.jwtdemo.jwt.JwtTokenUtil;
import com.learn.jwtdemo.jwt.WebContextUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description: 用户认证拦截器
 * @Author: lh
 * @Date: 2021/1/12 15:19
 **/
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取 token
        String token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);

        //非映射方法，直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //如果方法有JwtIgnore注解，直接通过
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(JwtIgnore.class)) {
            JwtIgnore jwtIgnore = method.getAnnotation(JwtIgnore.class);
            if (jwtIgnore.isIgnore()) {
                return true;
            }

        }

        if (ObjectUtils.isEmpty(token)) {
            throw new RuntimeException("获取认证信息失败！");
        }

        //验证 token
        String userToken = JwtTokenUtil.verifyToken(token);

        // 设置本地缓存
        WebContextUtil.setUserToken(userToken);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //方法结束，删除缓存 token
        WebContextUtil.removeUserToken();
    }
}
