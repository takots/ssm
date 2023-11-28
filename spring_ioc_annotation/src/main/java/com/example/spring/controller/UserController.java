package com.example.spring.controller;

import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    public  void saveUser(){
        userService.saveUser();
    }
}
