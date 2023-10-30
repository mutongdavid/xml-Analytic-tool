package com.example.xmlanalysis.service;

import com.example.xmlanalysis.domain.XmlData;
import com.example.xmlanalysis.domain.XmlDto;
import com.example.xmlanalysis.util.ExcelReader;
import com.example.xmlanalysis.util.ResourceUtils;
import com.example.xmlanalysis.util.XmlEscapeUtil;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class XmlAnalysisService {

    public XmlDto translate(InputStream inputStream) throws DocumentException {

        XmlDto result = new XmlDto();

        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element rootElement = document.getRootElement();

        List<XmlData> xmlData = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<XmlData> list = ExcelReader.readExcel("data.xlsx", i);
            try {
                traverseNode(rootElement, list);

                List<String> EShow = traverseENode(rootElement,new ArrayList<>(),"");
//                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i == 0) {
                result.setCShow(list.get(0));
            }
            if (i == 1) {
                result.setDShow(list.get(0));
            }
            if (i == 2) {
                result.setEShow(list.get(0));
            }
            if (i == 3) {
                result.setGShow(list.get(0));
            }
            xmlData.addAll(list);
        }
        result.setData(xmlData);
        return result;
    }


    private List<XmlData> traverseNode(Node node, List<XmlData> list) {
        List<String> tmpList = new ArrayList<>();
        if (node instanceof Element) {
            Element element = (Element) node;
            String elementString = element.asXML();
            // 处理元素节点的属性
            List<Attribute> attributes = element.attributes();
            for (Attribute attribute : attributes) {
                QName attributeName = attribute.getQName();
                String attributeValue = attribute.getValue();
//                System.out.println(attributeName.getName() + " = " + attributeValue);
                //查看是否是oid配配行
                for (int i = 0; i < list.size() - 1; i++) {
                    String oid = list.get(i).getOid();
                    if (attributeValue.equals(oid)) {
//                        System.out.println(list.get(i).toString());
                        if (elementString.contains(list.get(i).getCode())) {
                            tmpList.add(list.get(i).toString());
                            list.get(i).setXml(XmlEscapeUtil.escapeXml(elementString));

//                            list.get(i).setXml(elementString.replace("<", "[").replace("/>", "]"));
                        }
//                        System.out.println("节点名：" + element.getName());
//                        System.out.println(attributeName.getName() + " = " + attributeValue);
                    }
                }
            }

        }

        // 处理子节点
        Iterator<Element> iterator = ((Element) node).elementIterator();
        while (iterator.hasNext()) {
            Element child = iterator.next();
            traverseNode(child, list);
        }
        return list;
    }


    private List<String> traverseENode(Node node, List<String> xmlList, String xml) {
        if (node instanceof Element) {
            Element element = (Element) node;
            if (element.getName().equals("originalText") && element.getText().equals("E.i.1.1a")){
                xmlList.add(xml);
            }

//            System.out.println("节点名：" + element.getName());
            if (element.getName().equals("subjectOf2")){
                xml = element.asXML();
            }

        }

        Iterator<Element> iterator = ((Element) node).elementIterator();
        while (iterator.hasNext()) {
            Element child = iterator.next();
            traverseENode(child, xmlList , xml);
        }

        return xmlList;

    }

}
