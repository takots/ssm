package com.example.spring.test;

import com.example.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    /**
     * 1. 實例化
     * 2. 依賴注入
     * 3. 初始化 ,需要通過 bean 的 init-method 的屬性指定初始化的方法
     * 4. IOC容器關閉時銷毀 ,需要通過 bean 的 destroy-nethod 的屬性指定銷毀的方法
     */

    @Test
    public void test(){
        // 子接口才有關閉
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
