package com.learn.jwtdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 业务
 * @Author: lh
 * @Date: 2021/1/12 17:28
 **/
@RestController
@RequestMapping("/test")
public class BusinessController {

    @GetMapping("/query")
    public List<String> query() {
        return Arrays.asList("张三", "李四");
    }

}
