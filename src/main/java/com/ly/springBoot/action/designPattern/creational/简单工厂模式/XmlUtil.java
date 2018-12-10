package com.ly.springBoot.action.designPattern.creational.简单工厂模式;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @Author: LiuYi
 * @Description: 读取xml文件util
 * @Date: Created in 2018/12/10 16:19
 */
public class XmlUtil {
    public String getChartType() {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            InputStream stream = this.getClass().getResourceAsStream("/config.xml");
            Document document = documentBuilder.parse(stream);
            NodeList nodeList = document.getElementsByTagName("chartType");
            Node firstChild = nodeList.item(0).getFirstChild();
            return firstChild.getNodeValue().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
