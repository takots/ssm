package com.example.springmvc.controller;

import com.example.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(
            value = {"/hello" ,"/abc"},
            method = {RequestMethod.POST ,RequestMethod.GET},
//            params = {"username" ,"!password" ,"age=20" ,"gender!=M"}
            headers = {"referer"}
    )
    public String hello(){
        return "success";
    }

    @RequestMapping("/a?c/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/abc/te*/ant")
    public String testAnt2(){
        return "success";
    }

    @RequestMapping("/abc/test/**/ant")
    public String testAnt3(){
        return "success";
    }

    @RequestMapping("/??zzz/**/*e23/ant")
    public String testAnt4(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id ,@PathVariable("username") String username){
        System.out.println("id:"+id +",username:"+username);
        return "success";
    }

    @RequestMapping("/param/servletAPI")
    public String getParamServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getRequestParam(
            @RequestParam(value = "userName" ,required = false ,defaultValue = "hello") String username ,
            String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/cookie")
    public String newCookie(HttpServletRequest request){
        HttpSession session = request.getSession();
        return "success";
    }
    @RequestMapping("/header")
    public String getHeader(
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId
    ){
        System.out.println("referer:"+referer+",jsessionId:"+jsessionId);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getUser(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testScope", "hello,servletAPI");
        return "success";
    }

}
