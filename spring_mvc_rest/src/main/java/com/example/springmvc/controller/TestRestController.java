package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 查詢用戶信息:   /user    - get
 * id查詢用戶信息: /user/1  - get
 * 添加用戶信息:   /user    - post
 * 修改用戶信息:   /user    - put
 * 刪除用戶信息:   /user/1  - delete
 */
//@Controller
public class TestRestController {

    @RequestMapping(
            value="/user/{id}",
            method = RequestMethod.GET
    )
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("/user"+"/"+id+" get");
        return "success";
    }

    @RequestMapping(
            value="/user",
            method = RequestMethod.POST
    )
    public String insertUser(){
        System.out.println("/user post");
        return "success";
    }

    @RequestMapping(
            value="/user",
            method = RequestMethod.PUT
    )
    public String updateUser(){
        System.out.println("/user put");
        return "success";
    }

    @RequestMapping(
            value="/user/{id}",
            method = RequestMethod.DELETE
    )
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("/user"+"/"+id+" delete");
        return "success";
    }
}
