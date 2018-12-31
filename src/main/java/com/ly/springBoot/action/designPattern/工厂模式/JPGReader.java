package com.ly.springBoot.action.designPattern.工厂模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/12 14:13
 */
public class JPGReader implements Reader{
    @Override
    public void readerPic() {
        System.out.println("JPG读取");
    }
}
