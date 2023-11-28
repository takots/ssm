package com.example.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean的生命週期初始化之前執行
        System.out.println("後置處理器 postProcessBeforeInitialization");
//        System.out.println("beanName:" + beanName + " ,bean: " + bean);
//        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean的生命週期初始化之後執行
        System.out.println("後置處理器 postProcessAfterInitialization");
//        System.out.println("beanName:" + beanName + " ,bean: " + bean);
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
        return null;
    }
}
