package com.ly.springBoot.action.designPattern.Structural.组合模式;

/**
 * @Author: LiuYi
 * @Description: 部门,叶子部件
 * @Date: Created in 2019/1/2 16:23
 */
public class Department extends Unit{
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add(Unit unit) {
        System.out.println("叶子部件不支持添加");
    }

    @Override
    public void remove(Unit unit) {
        System.out.println("叶子部件不支持删除");
    }

    @Override
    public Unit getChilde(Integer index) {
        System.out.println("叶子部件不支持获取子节点");
        return null;
    }

    @Override
    public void sendMsg() {
        System.out.println(name+"发送消息");
    }
}
