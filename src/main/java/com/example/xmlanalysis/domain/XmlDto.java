package com.example.xmlanalysis.domain;

import lombok.Data;

import java.util.List;

@Data
public class XmlDto {
    List<XmlData> data;
    XmlData CShow;
    XmlData DShow;
    XmlData EShow;
    XmlData GShow;
}
