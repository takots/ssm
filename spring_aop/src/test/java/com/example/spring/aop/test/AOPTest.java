package com.example.spring.aop.test;

import com.example.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
//    org.springframework.beans.factory.NoSuchBeanDefinitionException:
//    No qualifying bean of type 'com.example.spring.aop.annotation.Calculator' available

    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
//        calculator.add(1,2);
        calculator.div(1,1);
    }
}
