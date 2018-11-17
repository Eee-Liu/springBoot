package com.ly.springBoot.action.designModel.装饰模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/11/7 20:33
 */
public class TShirts extends Finery {
    public void show() {
        System.out.println("穿T恤的,");
        person.show();
    }
}
