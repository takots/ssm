package com.example.springmvc.controller;

import com.example.springmvc.dao.EmployeeDao;
import com.example.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * 查詢員工信息:   /employee    - get
 * 跳轉添加頁面:   /to/add      - get
 * 新增員工信息:   /employee    - post
 * 跳轉修改頁面:   /employee/1  - get
 * 修改員工信息:   /employee    - put
 * 刪除員工信息:   /employee/1  - delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public ModelAndView getAllEmployee(){
        ModelAndView mav = new ModelAndView();
        Collection<Employee> allEmployee = employeeDao.getAll();
        mav.addObject("allEmployee",allEmployee);
        mav.setViewName("employee_list");
        return mav;
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        // 保存員工信息
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    /**
     * 帶該員工資訊 跳轉到 update page
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
    public ModelAndView toUpdatePage(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView();
        // 保存員工信息
        Employee employee = employeeDao.get(id);
        mav.addObject("employee",employee);
        mav.setViewName("employee_update");
        return mav;
    }

    /**
     * 更新員工資訊
     * @param employee
     * @return
     */
    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

}
