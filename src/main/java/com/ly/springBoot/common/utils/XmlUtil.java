package com.ly.springBoot.common.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.Date;

/**
 * @Author: LiuYi
 * @Description: 读取xml文件util
 * @Date: Created in 2018/12/10 16:19
 */
public class XmlUtil {
    public String getChartType() {
        return getChartType("chartType");
    }

    public String getChartType(String labelName) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            InputStream stream = this.getClass().getResourceAsStream("/config.xml");
            Document document = documentBuilder.parse(stream);
            NodeList nodeList = document.getElementsByTagName(labelName);
            Node firstChild = nodeList.item(0).getFirstChild();
            return firstChild.getNodeValue().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static void main(String[] args) {
        System.out.println(new Date().getTime());
    }
}
