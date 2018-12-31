package com.ly.springBoot.action.designPattern.简单工厂模式;

import com.ly.springBoot.common.utils.XmlUtil;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/10 16:15
 */
public class Test {
    public static void main(String[] args) throws Exception {
        XmlUtil xmlUtil = new XmlUtil();
        Shape shape = ShapeFactory.createShape(xmlUtil.getChartType());
        shape.erase();
    }
}
