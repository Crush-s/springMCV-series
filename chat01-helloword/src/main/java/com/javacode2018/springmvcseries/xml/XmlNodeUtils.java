package com.javacode2018.springmvcseries.xml;

import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * @author crush
 */
public class XmlNodeUtils {

    /**
     * 解析xml节点数据
     * @param xml
     * @param nodeName 母节点名称
     * @param itemKey 行唯一字段名称
     * @return
     */
    public static Map<String, JsonObject> getXmlNodeValues (String xml, String nodeName, String itemKey) {
        //创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //创建DocumentBuilder对象
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse(new ByteArrayInputStream(xml.getBytes()));
            NodeList list = d.getElementsByTagName(nodeName);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public static void main(String[] args) {
        getXmlNodeValues("","","");
    }

}
