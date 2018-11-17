package com.ly.springBoot.action.designModel.装饰模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/11/7 20:26
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public void show() {
        System.out.println("装饰着" + name);
    }
}
