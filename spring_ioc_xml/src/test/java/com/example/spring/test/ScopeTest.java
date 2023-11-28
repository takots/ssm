package com.example.spring.test;

import com.example.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

    @Test
    public void testScope(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");

        Student student1 = ioc.getBean("studentZero",Student.class);
        Student student2 = ioc.getBean("studentZero",Student.class);
        System.out.print("默認 default>");
        System.out.print(student1 == student2);
        System.out.println();

        student1 = ioc.getBean("studentOne",Student.class);
        student2 = ioc.getBean("studentOne",Student.class);
        System.out.print("singleton>");
        System.out.print(student1 == student2); // 比較內存地址
        // 字符串是常量放在常量池 , str1 str2 equals 被重寫 這個equals比較的是內容
        System.out.println();

        student1 = ioc.getBean("studentTwo",Student.class);
        student2 = ioc.getBean("studentTwo",Student.class);
        System.out.print("prototype>");
        System.out.print(student1 == student2); // 比較內存地址
    }
}
