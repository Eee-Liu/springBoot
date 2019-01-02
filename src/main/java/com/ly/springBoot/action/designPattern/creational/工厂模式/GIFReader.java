package com.ly.springBoot.action.designPattern.creational.工厂模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/12 14:13
 */
public class GIFReader implements Reader ,Cloneable{
    @Override
    public void readerPic() {
        System.out.println("GIF读取");
    }

    public static void main(String[] args) {
        GIFReader gifReader = new GIFReader();
        Object clone =null;
        try {
             clone = gifReader.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Not support cloneable");
        }
        if (null!=clone){
            System.out.println(clone);
        }
    }
}
