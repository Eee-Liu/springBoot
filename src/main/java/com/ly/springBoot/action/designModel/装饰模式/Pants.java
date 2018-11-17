package com.ly.springBoot.action.designModel.装饰模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/11/7 20:37
 */
public class Pants extends Finery{
    public void show(){
        System.out.println("穿裤子的,");
        person.show();
    }
}
