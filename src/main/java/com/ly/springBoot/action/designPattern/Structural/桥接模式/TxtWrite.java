package com.ly.springBoot.action.designPattern.Structural.桥接模式;

public class TxtWrite implements WriteImpl{
    @Override
    public void writeFile() {
        System.out.println("输出成txt文件");
    }
}
