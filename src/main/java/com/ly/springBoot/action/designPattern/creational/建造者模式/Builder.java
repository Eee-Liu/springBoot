package com.ly.springBoot.action.designPattern.creational.建造者模式;

/**
 * @Author: LiuYi
 * @Description:   抽象建造者
 * @Date: Created in 2018/12/25 16:36
 */
public abstract class Builder {
    protected Techweb techweb = new Techweb();

    public abstract void buildMenu();

    public abstract void buildList();

    public abstract void buildMainWindow();

    public abstract void buildControlStrip();

    //钩子方法
    public Boolean isShowMenu() {
        return true;
    }

    public Boolean isShowList() {
        return true;
    }

    public Boolean isShowMainWindow() {
        return true;
    }

    public Boolean isShowControlStrip() {
        return true;
    }

    public Techweb create(){
        if (isShowMenu()){
            buildMenu();
        } if (isShowList()){
            buildList();
        } if (isShowMainWindow()){
            buildMainWindow();
        } if (isShowControlStrip()){
            buildControlStrip();
        }
        return techweb;
    }
}
