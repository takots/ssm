package com.example.spring.proxy.test;

import com.example.spring.proxy.Calculator;
import com.example.spring.proxy.CalculatorImpl;
import com.example.spring.proxy.CalculatorStaticProxy;
import com.example.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {
//    @Test
//    public void testProxy(){
//        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
//        proxy.add(1,2);
//    }
    @Test
    public void testProxy(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        // 不知道動態代理類的類型 ,但知道實現的接口
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);
//        proxy.div(1,0); //catch 異常測試
    }
}
