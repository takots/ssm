package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test/handler")
    public String testHandler(){
        System.out.println(1/0);
        return "success";
    }
}
