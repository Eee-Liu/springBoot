package com.ly.springBoot.action.designPattern.creational.建造者模式;

import com.alibaba.fastjson.JSONObject;
import com.ly.springBoot.common.utils.XmlUtil;

/**
 * @Author: LiuYi
 * @Description: 建造者模式,一步步创建复杂的对象,将对象的创建跟表现分离.使用同样的创建过程生产不同的对象
 * @Date: Created in 2018/12/25 16:46
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        XmlUtil xmlUtil = new XmlUtil();
        String builderName = xmlUtil.getChartType("builderName");
        Class<?> aClass = Class.forName(builderName);
        Builder builder = (Builder)aClass.newInstance();
        Techweb techweb = builder.create();
        String jsonStr = techweb.toString();
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        System.out.println(jsonStr);
    }
}
