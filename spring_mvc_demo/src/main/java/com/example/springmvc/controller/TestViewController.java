package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewController {



    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){
        return "forward:/aaaa";
    }
    @RequestMapping("/aaaa")
    public String testForward(){
        return "abc";
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){
        return "redirect:/aaaa";
    }
}
