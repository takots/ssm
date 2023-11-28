package com.example.spring.test;

import com.example.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
//    org.springframework.beans.factory.CannotLoadBeanClassException:
//    Cannot find class [com.example.spring.UserFactoryBean]
//    for bean with name 'user' defined in class path resource [spring-factory.xml];
//    nested exception is java.lang.ClassNotFoundException: com.example.spring.UserFactoryBean

    @Test
    public void testFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = (User)ioc.getBean("user");
        User user2 = (User)ioc.getBean(User.class);
        System.out.println(user);
        System.out.println(user2);
    }
}
