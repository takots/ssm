package com.example.ssm.controller;

import com.example.ssm.pojo.Employee;
import com.example.ssm.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 查詢所有的員工信息 --> /employee  -get
 * 根據id的員工信息  --> /employee/1 -get
 * 跳轉添加頁面      --> /to/add    -get
 * 添加的員工信息     --> /employee -post
 * 修改的員工信息     --> /employee -put
 * 刪除的員工信息     --> /employee -delete
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployService employService;

    @RequestMapping(value="/employee" ,method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        List<Employee> list = employService.getAllEmployee();
        model.addAttribute("list",list);
        return "employee_list";
    }
}
