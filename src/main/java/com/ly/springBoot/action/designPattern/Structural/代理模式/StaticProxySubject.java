package com.ly.springBoot.action.designPattern.Structural.代理模式;

/**
 * @Author: LiuYi
 * @Description: 静态代理, 代理类跟方法需要提前定义好, 存在
 * @Date: Created in 2019/2/21 10:42
 */
public class StaticProxySubject implements Subject {
    //持有真实目标对象的引用,方便随时调用真是目标的方法
    private Subject subject;

    public StaticProxySubject(Subject subject) {
        this.subject = subject;
    }

    private void preRequest() {
        System.out.println("操作之前,权限校验");
    }

    private void postRequest() {
        System.out.println("操作之后,记录日志");
    }

    @Override
    public void operation() {
        preRequest();
        subject.operation();
        postRequest();
    }
}
