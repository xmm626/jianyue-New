package com.spring.jianyue.api.controller;

import com.spring.jianyue.api.entity.User;
import com.spring.jianyue.api.entity.vo.ArticleVO;
import com.spring.jianyue.api.service.ArticleService;
import com.spring.jianyue.api.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping(value = "/api/excel")
public class ExcelController {

    @Autowired
    private ArticleService articleService;

    //创建表头
    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(3,17*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(style);


        cell = row.createCell(1);
        cell.setCellValue("显示名");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("用户名");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("创建时间");
        cell.setCellStyle(style);
    }

    //生成Article表excel
    @GetMapping(value = "/getart")
    public String getArticle(HttpServletResponse response) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");
        createTitle(workbook,sheet);
        List<ArticleVO> rows = articleService.selectAll();

        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
        int rowNum=1;
        for(ArticleVO articleVO:rows){
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(articleVO.getId());
            row.createCell(1).setCellValue(articleVO.getuId());
            row.createCell(2).setCellValue(articleVO.getTitle());
            row.createCell(3).setCellValue(articleVO.getContent());
            row.createCell(4).setCellValue(articleVO.getNickname());
          //  row.createCell(5).setCellValue(articleVO.getAvatar());
            HSSFCell cell = row.createCell(3);
            cell.setCellValue(articleVO.getCreateTime());
            cell.setCellStyle(style);
            rowNum++;
        }

        String fileName = "导出excel例子.xls";

        //生成excel文件
        buildExcelFile(fileName, workbook);

        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);

        return "download excel";
    }

    //生成excel文件
    protected void buildExcelFile(String filename,HSSFWorkbook workbook) throws Exception{
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }

    //浏览器下载excel
    protected void buildExcelDocument(String filename,HSSFWorkbook workbook,HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }



}
