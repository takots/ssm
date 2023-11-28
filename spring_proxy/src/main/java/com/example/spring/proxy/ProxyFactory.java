package com.example.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        // ClassLoader: 加载动态生成的代理类的类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        // Class<?>[]: 目标对象实现的所有接口的class对象所组成的数组
        Class<?>[] interfaces = target.getClass().getInterfaces();
        // InvocationHandler: 设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[日志] 方法: "+method.getName()+"，参数: "+ Arrays.toString(args));
                    // proxy: 代理对象
                    // method: 代理对象需要实现的方法，即其中需要重写的方法
                    // args: method所对应方法的参数
                    result = method.invoke(target ,args);
                    System.out.println("[日志] 方法: "+method.getName()+"，結果: "+ result);
                }catch (Exception e){
                    System.out.println("[日志] 方法: "+method.getName()+"，異常: "+ e);
                }finally {
                    System.out.println("[日志] 方法: "+method.getName()+"，方法執行完畢");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader ,interfaces,invocationHandler);
    }
}
