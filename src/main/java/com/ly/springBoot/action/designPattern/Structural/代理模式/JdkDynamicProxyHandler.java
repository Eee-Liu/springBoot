package com.ly.springBoot.action.designPattern.Structural.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: LiuYi
 * @Description: JDK动态代理的动态处理器,jdk代理的目标对象必须要实现接口
 * @Date: Created in 2019/2/21 10:56
 */
public class JdkDynamicProxyHandler implements InvocationHandler {
    //维护目标对象
    private Object object;

    public JdkDynamicProxyHandler(final Object object) {
        this.object = object;
    }

    /*
     * Q:jdk动态代理为什么在debug时,会多次执行invoke内部方法
     * A:代理目标类时会代理该类的所有方法(包括toString),debug调试时IDEA会调用被代理类的toString()方法,因此会重复输出时间。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //输出代理的方法
        System.out.println("=========="+method.getName()+"=============");
        System.out.println("前>>>");
        Object result = method.invoke(object, args);
        System.out.println("后<<<");
        return result;
    }
}
