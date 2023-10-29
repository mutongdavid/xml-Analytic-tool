package com.example.xmlanalysis.domain;

import lombok.Data;

@Data
public class XmlData {
    String code;
    String name;
    String required;
    String type;
    String oid;
    String xml;

    @Override
    public String toString() {
        return "XmlData{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", required='" + required + '\'' +
                ", type='" + type + '\'' +
                ", oid='" + oid + '\'' +
                ", xml='" + xml + '\'' +
                '}';
    }
}
