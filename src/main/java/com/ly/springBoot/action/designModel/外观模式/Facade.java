package com.ly.springBoot.action.designModel.外观模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/11/17 17:33
 */
public class Facade {
    //因为门户类需要与不同的类交互,需要知道其属性跟方法,所以采用组合方式,在Facade类中加入子系统类作为属性
    private SubSystemOne subSystemOne;
    private SubSystemTwo subSystemTwo;
    private SubSystemThree subSystemThree;

    public Facade() {
        subSystemOne=new SubSystemOne();
        subSystemTwo=new SubSystemTwo();
        subSystemThree=new SubSystemThree();
    }

    public void methodOne(){
        subSystemOne.method();
        subSystemTwo.method();
    }

    public void methodTwo(){
        subSystemOne.method();
        subSystemThree.method();
    }
}
