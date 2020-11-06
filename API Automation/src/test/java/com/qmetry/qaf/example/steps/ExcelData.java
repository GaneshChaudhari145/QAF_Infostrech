package com.qmetry.qaf.example.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public Map<String, String> getData(String sheetName) throws IOException {

		System.out.println("Inside Read excel--------------------------");
		String path="D:\\TestData.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		
		XSSFWorkbook  workbook = new XSSFWorkbook(fis);
		
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		
		Map<String, String> datamap =new HashMap<String,String>();
		for(int i=1; i<=lastRow; i++)
		{
			Row row = sheet.getRow(i);
			Cell valueCell = row.getCell(1);
			Cell keyCell = row.getCell(0);
			String value = valueCell.getStringCellValue();
			String key = keyCell.getStringCellValue();
			datamap.put(key, value);
			System.out.println(datamap);
			workbook.close();
		}
		return  datamap;
		
	}
}
