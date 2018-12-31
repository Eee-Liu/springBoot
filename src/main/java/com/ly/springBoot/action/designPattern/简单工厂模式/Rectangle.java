package com.ly.springBoot.action.designPattern.简单工厂模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/10 16:09
 */
public class Rectangle implements Shape{

    public Rectangle(){
        System.out.println("画了个长方形");
    }

    @Override
    public void draw() {
        System.out.println("画了个长方形");
    }

    @Override
    public void erase() {
        System.out.println("擦除了个长方形");
    }
}
