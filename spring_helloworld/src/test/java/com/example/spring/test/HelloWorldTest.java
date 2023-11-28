package com.example.spring.test;

import com.example.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void test(){
        // 獲取IOC容器
        ApplicationContext ioc = new FileSystemXmlApplicationContext("applicationContext.xml");
        // 獲取IOC容器中的Bean
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();

    }
}
