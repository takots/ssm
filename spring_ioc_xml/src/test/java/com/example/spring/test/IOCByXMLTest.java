package com.example.spring.test;

import com.example.spring.pojo.Clazz;
import com.example.spring.pojo.Person;
import com.example.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    @Test
    public void testIOC(){
        // 獲取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // 獲取bean
        Student studentOne = (Student) ioc.getBean("studentOne");
        System.out.println(studentOne);
    }

    @Test
    public void testDI(){
        // 獲取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // 獲取bean
//        Student student = ioc.getBean(Student.class);

        // 通過向上轉型給了Person
//        Person person = ioc.getBean(Student.class);
//        Person person = ioc.getBean(Person.class);

//        Student student = ioc.getBean("studentTwo",Student.class);

//        Student student = ioc.getBean("studentFour",Student.class);
//        System.out.println(student.getSname().toString());
//
//        Student student = ioc.getBean("studentSeven",Student.class);
//        System.out.println(student);

//        Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
//        System.out.println(clazz);

//        Student student = ioc.getBean("studentEight",Student.class);
//        System.out.println(student);

//        Clazz clazz = ioc.getBean("clazzFour", Clazz.class);
//        System.out.println(clazz);

        Student student = ioc.getBean("studentEleven",Student.class);
        System.out.println(student);

    }
}
