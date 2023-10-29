package com.example.xmlanalysis.service;

import org.dom4j.Element;
import org.dom4j.ElementPath;

public class ElementHandler implements org.dom4j.ElementHandler {
    private  static  int num =1;
    @Override
    public void onStart(ElementPath elementPath) {
        Element element = elementPath.getCurrent();
        num++;
        System.out.println("Element: " + element.getName() + ", Line Number: " + num);
    }

    @Override
    public void onEnd(ElementPath elementPath) {
        // 不需要实现该方法
    }



}
