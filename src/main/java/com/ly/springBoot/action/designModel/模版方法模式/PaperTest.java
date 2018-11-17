package com.ly.springBoot.action.designModel.模版方法模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/11/9 16:49
 */
public abstract class PaperTest {
    public void one() {
        System.out.println("第一道题:");
        answerOne();
    }

    public void two() {
        System.out.println("第二道题:");
        answerTwo();
    }

    public void three() {
        System.out.println("第三道题:");
        answerThree();
    }

    abstract void answerOne();

    abstract void answerTwo();

    abstract void answerThree();
}
