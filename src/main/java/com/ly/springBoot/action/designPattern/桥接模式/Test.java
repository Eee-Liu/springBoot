package com.ly.springBoot.action.designPattern.桥接模式;

/**
 * @Author: LiuYi
 * @Description: 桥接模式,将影响一个类的两个或多个维度因素,分为抽象部分跟实现部分,连着为关联关系,并且
 * 二者可以独立进行扩展.
 * @Date: Created in 2018/12/7 17:32
 */
public class Test {
    public static void main(String[] args) {
        //对象的创建可以根据配置文件,动态生成
        WriteImpl impl = new ExcelWrite();
        ReadAbstrac abstrac = new OracleRead();
        abstrac.setImpl(impl);
        abstrac.readData();
    }
}
