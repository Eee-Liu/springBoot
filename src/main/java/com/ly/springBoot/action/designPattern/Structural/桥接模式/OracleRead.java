package com.ly.springBoot.action.designPattern.Structural.桥接模式;

public class OracleRead extends ReadAbstrac{
    @Override
    public void readData() {
        System.out.print("从oracle读取数据,");
        impl.writeFile();
    }
}
