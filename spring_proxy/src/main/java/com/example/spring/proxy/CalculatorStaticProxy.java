package com.example.spring.proxy;

public class CalculatorStaticProxy implements Calculator{

    private  CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        int result = target.add(i ,j);
        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始了，参数是：" + i + "," + j);
        int result = target.div(i ,j);
        System.out.println("[日志] div 方法结束了，结果是：" + result);
        return result;
    }
}
