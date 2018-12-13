package com.ly.springBoot.action.designPattern.creational.工厂模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/12 14:13
 */
public class GIFReader implements Reader {
    @Override
    public void readerPic() {
        System.out.println("GIF读取");
    }
}
