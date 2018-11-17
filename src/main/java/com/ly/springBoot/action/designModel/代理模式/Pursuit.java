package com.ly.springBoot.action.designModel.代理模式;

/**
 * @Author: LiuYi
 * @Description: 追求者
 * @Date: Created in 2018/11/8 17:46
 */
public class Pursuit implements GIveGife {
    //追求对象
    private Schoolgirl schoolgirl;

    public Pursuit(Schoolgirl schoolgirl) {
        this.schoolgirl = schoolgirl;
    }

    @Override
    public void giveFlower() {
        System.out.println("送花给" + schoolgirl.getName());
    }

    @Override
    public void giveDolls() {
        System.out.println("送娃娃" + schoolgirl.getName());
    }

    @Override
    public void giveFood() {
        System.out.println("送吃的" + schoolgirl.getName());
    }
}
