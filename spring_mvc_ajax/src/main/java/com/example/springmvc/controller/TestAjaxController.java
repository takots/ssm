package com.example.springmvc.controller;

import com.example.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestAjaxController {

    // ajax 局部刷新
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id , @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("id:"+id);
        System.out.println("requestBody:"+requestBody);
        response.getWriter().write("hello axios");
    }

    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody User user , HttpServletResponse response) throws IOException {
        System.out.println(user);//@RequestBody User user
//        System.out.println(map);@RequestBody Map<String,Object> map
        response.getWriter().write("hello requestBody");
    }

    @RequestMapping("/test/responseBody1")
    public String testResponseBody1(){
        return "success"; // success.html
    }
    @RequestMapping("/test/responseBody2")
    @ResponseBody
    public String testResponseBody2(){
        return "success"; // 瀏覽器響應了這個字串
    }
    @RequestMapping("/test/response/json")
    @ResponseBody
    public User testResponseBody3(){
        User user = new User(1001 ,"admin" ,"12345" ,20 ,"m" );
        return user;
    }
    @RequestMapping("/test/response/map")
    @ResponseBody
    public Map<String ,Object> testResponseBody4(){
        Map<String ,Object> map = new HashMap<>();
        User user1 = new User(1001 ,"admin" ,"12345" ,20 ,"m" );
        User user2 = new User(1002 ,"admin" ,"12345" ,20 ,"m" );
        User user3 = new User(1003 ,"admin" ,"12345" ,20 ,"m" );
        map.put("1001", user1);
        map.put("1002", user2);
        map.put("1003", user3);
        return map;
    }

    @RequestMapping("/test/response/list")
    @ResponseBody
    public List<User> testResponseBody5(){
        User user1 = new User(1001 ,"admin" ,"12345" ,20 ,"m" );
        User user2 = new User(1002 ,"admin" ,"12345" ,20 ,"m" );
        User user3 = new User(1003 ,"admin" ,"12345" ,20 ,"m" );
        List<User> list = Arrays.asList(user1 ,user2 ,user3);
        return list;
    }
}
