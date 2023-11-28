package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 查詢用戶信息:   /user    - get
 * id查詢用戶信息: /user/1  - get
 * 添加用戶信息:   /user    - post
 * 修改用戶信息:   /user    - put
 * 刪除用戶信息:   /user/1  - delete
 */
@Controller
public class TestRestController2 {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("/user"+"/"+id+" get");
        return "success";
    }

    @PostMapping("/user")
    public String insertUser(){
        System.out.println("/user post");
        return "success";
    }

    @PutMapping("/user")
    public String updateUser(){
        System.out.println("/user put");
        return "success";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("/user"+"/"+id+" delete");
        return "success";
    }
}
