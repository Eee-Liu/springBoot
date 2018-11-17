package com.ly.springBoot.action.designModel.代理模式;

/**
 * @Author: LiuYi
 * @Description: 代理者
 * @Date: Created in 2018/11/8 17:47
 */
public class Proxy implements GIveGife {
    //代理对象
    private Pursuit pursuit;

    public Proxy(Schoolgirl schoolgirl) {
        this.pursuit = new Pursuit(schoolgirl);
    }

    @Override
    public void giveFlower() {
        pursuit.giveFlower();
    }

    @Override
    public void giveDolls() {
        pursuit.giveDolls();
    }

    @Override
    public void giveFood() {
        pursuit.giveFood();
    }
}
