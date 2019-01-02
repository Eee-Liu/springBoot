package com.ly.springBoot.action.designPattern.Structural.组合模式;

/**
 * @Author: LiuYi
 * @Description: 单位,抽象部件
 * @Date: Created in 2019/1/2 16:20
 */
public abstract class Unit {
    public abstract void add(Unit unit);
    public abstract void remove(Unit unit);
    public abstract Unit getChilde(Integer index);
    public abstract void sendMsg();
}
