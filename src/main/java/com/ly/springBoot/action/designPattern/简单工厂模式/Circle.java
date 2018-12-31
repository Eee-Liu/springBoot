package com.ly.springBoot.action.designPattern.简单工厂模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/10 16:08
 */
public class Circle implements Shape{

    public Circle(){
        System.out.println("画了个圆");
    }
    @Override
    public void draw() {
        System.out.println("画了个圆");
    }

    @Override
    public void erase() {
        System.out.println("擦除了个圆");
    }
}
