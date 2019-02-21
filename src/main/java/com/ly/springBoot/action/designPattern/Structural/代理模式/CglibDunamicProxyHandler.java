package com.ly.springBoot.action.designPattern.Structural.代理模式;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: LiuYi
 * @Description: Cglib创建的动态代理对象比JDK创建的动态代理对象的性能更高，但是CGLIB创建代理对象时所花费的时间却比JDK多得多。
 * 所以对于单例的对象，因为无需频繁创建对象，用CGLIB合适，反之使用JDK方式要更为合适一些。同时由于CGLib由于是采用动态创建子类的
 * 方法,目标对象的方法如果为final/static,那么就无法进行代理。
 * @Date: Created in 2019/2/21 15:07
 */
public class CglibDunamicProxyHandler implements MethodInterceptor {
    //维护目标对象
    private Object target;

    public CglibDunamicProxyHandler(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类(代理对象)
        return enhancer.create();
    }
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务...");
        /*
            两种请求方法:
            1.调用methodProxy.invoke(target, args)<target为维护的目标对象>
            2.调用methodProxy.invokeSuper(object, args)<object为参数列表中参数>,若调用invoke()会死循环
         */
        Object result = methodProxy.invoke(target, args);
//        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("结束事务...");
        return result;
    }
}
