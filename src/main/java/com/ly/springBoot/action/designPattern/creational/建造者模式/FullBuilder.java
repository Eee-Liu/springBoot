package com.ly.springBoot.action.designPattern.creational.建造者模式;

/**
 * @Author: LiuYi
 * @Description: 完整模式
 * @Date: Created in 2018/12/25 16:40
 */
public class FullBuilder extends Builder{
    @Override
    public void buildMenu() {
        techweb.setMenu("full菜单");
    }

    @Override
    public void buildList() {
        techweb.setList("full播放列表");
    }

    @Override
    public void buildMainWindow() {
        techweb.setMainWindow("full主窗口");
    }

    @Override
    public void buildControlStrip() {
        techweb.setControlStrip("full控制条");
    }
}
