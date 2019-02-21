package com.ly.springBoot.action.designPattern.Structural.代理模式;

import java.lang.reflect.Proxy;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2019/2/21 10:47
 */
public class Test {
    public static void main(String[] args) {
        //静态代理
//        RealSubject subject = new RealSubject();
//        StaticProxySubject proxySubject = new StaticProxySubject(subject);
//        proxySubject.operation();


        RealSubject realSubject = new RealSubject();
        //Jdk动态代理
        /*
         * 注意Proxy.newProxyInstance()方法接受三个参数：
         *  ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
         *  Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
         *  InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
         */
//        Subject jdkProxySubject = (Subject) Proxy.newProxyInstance(
//                realSubject.getClass().getClassLoader(),
//                new Class[]{Subject.class},
//                new JdkDynamicProxyHandler(realSubject));
//        jdkProxySubject.operation();

        //Cglib动态代理
        RealSubject2 realSubject2 = new RealSubject2();
        RealSubject2 cglibProxyInstance = (RealSubject2) new CglibDunamicProxyHandler(realSubject2).getProxyInstance();
        cglibProxyInstance.ss();
    }
}
