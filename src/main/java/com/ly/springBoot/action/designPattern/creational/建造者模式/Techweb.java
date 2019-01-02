package com.ly.springBoot.action.designPattern.creational.建造者模式;

import java.io.Serializable;

/**
 * @Author: LiuYi
 * @Description: 界面对象
 * @Date: Created in 2018/12/25 16:33
 */
public class Techweb implements Serializable {

    private String menu;
    private String list;
    private String mainWindow;
    private String controlStrip;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(String mainWindow) {
        this.mainWindow = mainWindow;
    }

    public String getControlStrip() {
        return controlStrip;
    }

    public void setControlStrip(String controlStrip) {
        this.controlStrip = controlStrip;
    }

    @Override
    public String toString() {
        return '{' +
                "'menu':'" + menu + '\'' +
                ", 'list':'" + list + '\'' +
                ", 'mainWindow':'" + mainWindow + '\'' +
                ", 'controlStrip':'" + controlStrip + '\'' +
                '}';
    }
}
