package com.gomefinance.hl.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hzj
 * @Date 2017/6/21 22:04
 * @Description :
 */
@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @GetMapping("mysql")
    @ResponseBody
    public String mysql() {
        return "this is mysql course";
    }

    @GetMapping("springboot")
    @ResponseBody
    public String springboot() {
        return "this is springboot course";
    }

    @GetMapping("java")
    @ResponseBody
    public String java() {
        return "this is java course";
    }

}
