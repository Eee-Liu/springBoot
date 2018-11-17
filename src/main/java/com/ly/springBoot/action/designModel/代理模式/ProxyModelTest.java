package com.ly.springBoot.action.designModel.代理模式;

/**
 * @Author: LiuYi
 * @Description: 代理模式,为其他对象提供一种代理以控制对这个对象的访问
 * 具体应用场景待摸索
 * @Date: Created in 2018/11/8 17:52
 */
public class ProxyModelTest {
    public static void main(String[] args) {
        Schoolgirl schoolgirl = new Schoolgirl("lucy");
        Proxy proxy = new Proxy(schoolgirl);
        proxy.giveDolls();
        proxy.giveFlower();
        proxy.giveFood();
    }
}
