package com.example.xmlanalysis.util;

import java.util.HashMap;
import java.util.Map;

public class XmlEscapeUtil {

    private static final Map<String, String> XML_ESCAPES;

    static {
        XML_ESCAPES = new HashMap<>();
        XML_ESCAPES.put("&", "&amp;");
        XML_ESCAPES.put("<", "&lt;");
        XML_ESCAPES.put(">", "&gt;");
        XML_ESCAPES.put("\"", "&quot;");
        XML_ESCAPES.put("'", "&#39;");
    }

    public static String escapeXml(String xml) {
        StringBuilder escapedXml = new StringBuilder();
        for (char c : xml.toCharArray()) {
            String escape = XML_ESCAPES.get(Character.toString(c));
            if (escape != null) {
                escapedXml.append(escape);
            } else {
                escapedXml.append(c);
            }
        }
        return escapedXml.toString();
    }

    public static void main(String[] args) {
        String xml = "<person><name>John Doe</name><age>30</age><gender>Male</gender></person>";
        String escapedXml = escapeXml(xml);
        System.out.println(escapedXml);
    }
}

