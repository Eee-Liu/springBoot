package com.ly.springBoot.action.designPattern.桥接模式;

public class MysqlRead extends ReadAbstrac{
    @Override
    public void readData() {
        System.out.print("从mysql读取数据,");
        impl.writeFile();
    }
}
