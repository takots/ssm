package com.example.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1234)// 優先級，數字越小優先級越高
public class ValidateAspect {
    // 使用 LoggerAspect 的 公共的切入點表達式
    @Before("com.example.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect , 前置通知");
    }
}
