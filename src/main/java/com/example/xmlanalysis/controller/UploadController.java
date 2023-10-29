package com.example.xmlanalysis.controller;

import com.example.xmlanalysis.domain.ResultDto;
import com.example.xmlanalysis.domain.XmlDto;
import com.example.xmlanalysis.service.XmlAnalysisService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UploadController {
    @Autowired
    XmlAnalysisService xmlAnalysisService;

    //文件上传
    @RequestMapping("/upload")
    public String uploadFile(@RequestParam("file00") MultipartFile file, Model model) {
        try {
            InputStream inputStream = file.getInputStream();
            byte[] bytes = new byte[(int) file.getSize()];
            inputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("文件上传成功！");

//        List<String> list = new ArrayList<String>();
//        list.add("C.1.1");
//        list.add("D.1");
//        list.add("E.i.1.1a,E.i.1.1a,E.i.1.1a,E.i.1.1a,E.i.1.1a,E.i.1.1a");
//        list.add("G.k.2.2,G.k.2.2,G.k.2.2");
//
//        model.addAttribute("rData",list);

        //组装数据返回给前端
        model.addAttribute("C","C.1.1");
        model.addAttribute("D","D.1");
        model.addAttribute("E","E.i.1.1a,E.i.1.1a,E.i.1.1a,E.i.1.1a,E.i.1.1a,E.i.1.1a");
        model.addAttribute("G","G.k.2.2,G.k.2.2,G.k.2.2");

        return "xmlTable";

    }



    @PostMapping("/upload2")
    @ResponseBody
    public ResultDto uploadFile(@RequestParam("file00") MultipartFile file) throws Exception {
//        try {
//            InputStream inputStream = file.getInputStream();
//            byte[] bytes = new byte[(int) file.getSize()];
//            inputStream.read(bytes);
//            System.out.println(new String(bytes));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("文件上传成功！");


        XmlDto result = xmlAnalysisService.translate(file.getInputStream());

        return ResultDto.succ(result);

    }

}