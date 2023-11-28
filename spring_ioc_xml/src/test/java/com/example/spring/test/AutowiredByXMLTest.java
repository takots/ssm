package com.example.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredByXMLTest {
    @Test
    public void testDataSource() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowired.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
