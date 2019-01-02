package com.ly.springBoot.action.designPattern.Structural.桥接模式;

public class ExcelWrite implements WriteImpl{
    @Override
    public void writeFile() {
        System.out.println("输出成excel文件");
    }
}
