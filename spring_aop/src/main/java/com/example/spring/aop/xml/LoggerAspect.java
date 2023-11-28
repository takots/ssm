package com.example.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        // 獲取連接點所對應方法的簽名信息 (方法的聲明)
        Signature signature = joinPoint.getSignature();
        // 獲取連接點所對應方法的參數
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect , 前置通知 , 方法: " + signature.getName() + " , 參數: " + Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect , 後置通知 , 方法: " + signature.getName() + " , 執行完畢");
    }

    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object abc) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect , 返回通知 , 方法: " + signature.getName() + " , 結果: " + abc);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable efg) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect , 異常通知 , 方法: " + signature.getName() + " , 異常: " + efg);
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("環繞通知 --> 前置通知");
            // 表示目標對象方法的執行
            result = joinPoint.proceed();
            System.out.println("環繞通知 --> 返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("環繞通知 --> 異常通知");
        } finally {
            System.out.println("環繞通知 --> 後置通知");
        }
        return result;
    }
}
