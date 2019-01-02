package com.ly.springBoot.action.designPattern.Structural.桥接模式;

/**
 * @Author: LiuYi
 * @Description: 抽象部分,负责读取数据,关联一个输出数据的实现部分对象
 * @Date: Created in 2018/12/7 17:32
 */
public abstract class ReadAbstrac{
    protected WriteImpl impl;

    public void setImpl(WriteImpl impl) {
        this.impl = impl;
    }

    public abstract void readData();
}
