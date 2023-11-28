package com.example.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect // 將當前組件標示為切面
public class LoggerAspect {
    /**
     * 切入表達式: 設置在標示通知的註解的value屬性中
     * execution(public int com.example.spring.aop.annotation.CalculatorImpl.add(int ,int))
     * execution(* com.example.spring.aop.annotation.CalculatorImpl.*(..))
     * 第一個 * 任意的訪問修飾符和返回值類型
     * 第二個 * 類中任意方法
     * .. 任意的參數列表
     *
     * 獲取連接點的信息
     * 前置通知：使用@Before注解标识，在被代理的目标方法前执行
     * 返回通知：使用@AfterReturning注解标识，在被代理的目标方法成功结束后执行
     * 异常通知：使用@AfterThrowing注解标识，在被代理的目标方法异常结束后执行
     * 后置通知：使用@After注解标识，在被代理的目标方法最终结束后执行
     */

    // 聲明公共的切入點表達式
    @Pointcut("execution(* com.example.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    // AOP: 抽 橫切關注點 然後封裝到切面中 封裝為一個通知方法 再把通知方法透過 切入點表達式 作用到 連接點上
//    @Before("execution(public int com.example.spring.aop.annotation.CalculatorImpl.add(int ,int))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        // 獲取連接點所對應方法的簽名信息 (方法的聲明)
        Signature signature = joinPoint.getSignature();
        // 獲取連接點所對應方法的參數
        Object [] args = joinPoint.getArgs();
        System.out.println("LoggerAspect , 前置通知 , 方法: " +  signature.getName() + " , 參數: " + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect , 後置通知 , 方法: " +  signature.getName() + " , 執行完畢");
    }

    // 返回通知 若要獲取目標對象返回值，通過 @AfterReturning 的 returning 屬性就可以將返回值指定給相同名稱的參數
    @AfterReturning(value = "pointCut()" ,returning = "abc")
    public void afterRetunringAdviceMethod(JoinPoint joinPoint ,Object abc){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect , 返回通知 , 方法: "+  signature.getName() + " , 結果: " + abc);
    }

    @AfterThrowing(value = "pointCut()" ,throwing = "efg")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint ,Throwable efg){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect , 異常通知 , 方法: "+  signature.getName() + " , 異常: " + efg);
    }

    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try{
            System.out.println("環繞通知 --> 前置通知");
            // 表示目標對象方法的執行
            result = joinPoint.proceed();
            System.out.println("環繞通知 --> 返回通知");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("環繞通知 --> 異常通知");
        }finally {
            System.out.println("環繞通知 --> 後置通知");
        }
        return result;
    }
}
