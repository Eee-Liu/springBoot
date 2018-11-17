package com.ly.springBoot.action.designModel.外观模式;

/**
 * @Author: LiuYi
 * @Description: 外观模式,为子系统中的一组接口提供一个同意的界面,此模式定义了一个高层接口,这个接口使得这一子系统更加容易使用
 * 我的理解:类似门户网站,从用户需要与不同的网站交互来获取信息变成,用户只需跟一个门户类交互,由门户类在内部组装调用的逻辑.
 * 其实我们系统的不同Action跟AO也算一种门户类吧,如想知道权限相关的,用户只需跟AuthAction交互,AuthAction只需跟AuthAO交互
 * @Date: Created in 2018/11/17 17:28
 */
public class FacadeModelTest {
    public static void main(String[] args) {
        //使用模式之前,需要跟每个具体类交互
        SubSystemOne subSystemOne = new SubSystemOne();
        SubSystemTwo subSystemTwo = new SubSystemTwo();
        SubSystemThree subSystemThree = new SubSystemThree();
        subSystemOne.method();
        subSystemTwo.method();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        subSystemOne.method();
        subSystemThree.method();

        //使用模式之后,只需要跟门户类Facade交互
        Facade facade = new Facade();
        facade.methodOne();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        facade.methodTwo();
    }
}
