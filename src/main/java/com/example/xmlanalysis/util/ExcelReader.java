package com.example.xmlanalysis.util;

import com.example.xmlanalysis.domain.XmlData;
import com.example.xmlanalysis.domain.XmlDto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<XmlData> readExcel(String path, int colum) {
        List<XmlData> result = new ArrayList<>();
        try {
            // 获取文件输入流
            InputStream inputStream = ResourceUtils.getFileInputStream("classpath:/excel/"+path);
            Workbook workbook = null;

            workbook = new XSSFWorkbook(inputStream);

            // 获取第一张表
            assert workbook != null;
            Sheet sheet = workbook.getSheetAt(colum);
            // sheet.getPhysicalNumberOfRows()获取总的行数
            // 循环读取每一行
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                XmlData xmlData = new XmlData();
                // 循环读取每一个格
                Row row = sheet.getRow(i);
                // row.getPhysicalNumberOfCells()获取总的列数
                for (int index = 0; index < row.getPhysicalNumberOfCells(); index++) {
                    try {
                        // 获取数据，但是我们获取的cell类型
                        Cell cell = row.getCell(index);
                        // 转换为字符串类型
                        cell.setCellType(CellType.STRING);
                        // 获取得到字符串
                        String str = cell.getStringCellValue();
//                        Thread.sleep(100);
//                        System.out.print(str + "     ");

                        if (index==0){
                            xmlData.setCode(str);
                        }else if (index==1){
                            xmlData.setName(str);
                        }else if (index==2){
                            xmlData.setRequired(str);
                        }else if (index==3){
                            xmlData.setType(str);
                        }else if (index==4){
                            xmlData.setOid(str);
                        }


                    }catch (Exception e) {
//                        System.out.println("something wrong");
                    }
                }
//                System.out.println();
                result.add(xmlData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  result;
    }

}