package com.example.xmlanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/test1")
    public String test1()
    {
        return "test1";
    }

    @RequestMapping("/test2")
    public String upload()
    {
        return "test2";
    }

    @RequestMapping("/xmlTable")
    public String xmlTable()
    {
        return "xmlTable2";
    }
}
