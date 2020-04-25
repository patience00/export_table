package com.linchtech.export.table.service;

import com.linchtech.export.table.entity.Table;
import com.linchtech.export.table.entity.TableComment;
import com.linchtech.export.table.mapper.TableMapper;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author: 107
 * @date: 2019/7/11 14:20
 * @description:
 * @Review:
 */
@Service
@Slf4j
public class TableService {

    @Autowired
    private TableMapper tableMapper;

    public void getTable(String fileName, String database) throws IOException {
        List<TableComment> adasdb_v4 = tableMapper.getAllTableName(database);
        File file = new File("C:\\Users\\Desktop\\" + fileName);
        @Cleanup FileOutputStream outputStream = new FileOutputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook();
        for (TableComment tableName : adasdb_v4) {
            log.info("表名:{}", tableName);
            List<Table> tables = tableMapper.getFields(database, tableName.getName());
            XSSFSheet sheet = wb.createSheet(tableName.getName());
            XSSFRow row1 = sheet.createRow(0);
            row1.createCell(0).setCellValue("表名：" + tableName.getName() + "（" + tableName.getComment().substring(tableName.getComment().lastIndexOf(">") + 1) + "）");

            XSSFRow row = sheet.createRow(1);
            row.createCell(0).setCellValue("列名");
            row.createCell(1).setCellValue("数据类型");
            row.createCell(2).setCellValue("字段类型");
            row.createCell(3).setCellValue("长度");
            row.createCell(4).setCellValue("是否为空");
            row.createCell(5).setCellValue("默认值");
            row.createCell(6).setCellValue("备注");
            int rowIndex = 2;
            for (Table table : tables) {
                XSSFRow sheetRow = sheet.createRow(rowIndex++);
                sheetRow.createCell(0).setCellValue(table.getColumn());
                sheetRow.createCell(1).setCellValue(table.getDataType());
                sheetRow.createCell(2).setCellValue(table.getFieldType());
                sheetRow.createCell(3).setCellValue(table.getLength());
                sheetRow.createCell(4).setCellValue(table.getIsEmpty());
                sheetRow.createCell(5).setCellValue(table.getDefaultValue());
                sheetRow.createCell(6).setCellValue(table.getNote());
            }
        }
        wb.write(outputStream);
        wb.close();
    }
}
