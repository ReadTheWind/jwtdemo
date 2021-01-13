package com.learn.jwtdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.jwtdemo.annotation.JwtIgnore;
import com.learn.jwtdemo.bean.UserToken;
import com.learn.jwtdemo.jwt.JwtTokenUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 用户
 * @Author: lh
 * @Date: 2021/1/12 17:11
 **/
@RestController
public class UserController {

    @JwtIgnore
    @PostMapping(value = "/login")
    public UserToken login(@RequestBody UserToken userDto, HttpServletResponse response) {
        if (ObjectUtils.isEmpty(userDto)) {
            return null;
        }

        String token = JwtTokenUtil.createToken(JSONObject.toJSONString(userDto));
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, token);

        return userDto;
    }

}
