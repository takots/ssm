package com.example.spring.controller;

import com.example.spring.service.UserService;

public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public  void saveUser(){
        userService.saveUser();
    }
}
