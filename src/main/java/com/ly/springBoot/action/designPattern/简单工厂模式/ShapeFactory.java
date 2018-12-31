package com.ly.springBoot.action.designPattern.简单工厂模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/10 16:11
 */
public class ShapeFactory {
    public static Shape createShape(String shapeName) throws Exception {
        Shape shape;
        switch (shapeName) {
            case "circle":
                shape = new Circle();
                break;
            case "rectangle":
                shape = new Rectangle();
                break;
            default:
                shape = null;
                break;
        }
        if (shape == null) {
            throw new Exception("UnSupportedShapeException");
        }
        return shape;
    }
}
