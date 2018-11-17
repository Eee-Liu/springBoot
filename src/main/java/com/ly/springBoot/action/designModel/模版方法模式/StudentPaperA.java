package com.ly.springBoot.action.designModel.模版方法模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/11/9 16:51
 */
public class StudentPaperA extends PaperTest{
    @Override
    void answerOne() {
        System.out.println("A");
    }

    @Override
    void answerTwo() {
        System.out.println("B");
    }

    @Override
    void answerThree() {
        System.out.println("C");
    }
}
