package com.example.ssm.service.impl;

import com.example.ssm.mapper.EmployMapper;
import com.example.ssm.pojo.Employee;
import com.example.ssm.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployServiceImpl implements EmployService {
    @Autowired
    private EmployMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }
}
