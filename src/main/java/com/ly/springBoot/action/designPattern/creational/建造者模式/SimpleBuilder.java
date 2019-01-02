package com.ly.springBoot.action.designPattern.creational.建造者模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/25 16:45
 */
public class SimpleBuilder extends Builder{
    @Override
    public void buildMenu() {
        techweb.setMenu("simple菜单");
    }

    @Override
    public void buildList() {
        techweb.setList("simple播放列表");
    }

    @Override
    public void buildMainWindow() {
        techweb.setMainWindow("simple主窗口");
    }

    @Override
    public void buildControlStrip() {
        techweb.setControlStrip("simple控制条");
    }
    @Override
    public Boolean isShowMenu() {
        return false;
    }
    @Override
    public Boolean isShowList() {
        return false;
    }

}
