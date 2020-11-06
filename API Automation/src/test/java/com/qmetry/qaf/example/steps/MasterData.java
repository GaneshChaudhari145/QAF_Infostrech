package com.qmetry.qaf.example.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MasterData {


	public static final String path="D:\\TestData.xlsx";

	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;


	public static void loadExcel() throws IOException {
		File file= new File(path);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("LeaveManager");
		fis.close();
	}

	public static List<Map<String, String>> readData() throws IOException{

		if(sheet==null) {
			loadExcel();
		}
		System.out.println("Inside Read excel--------------------------");
		List<Map<String, String>> maplists=new ArrayList<>();

		int rows = sheet.getLastRowNum();
		row = sheet.getRow(0);

		for(int j=1; j<row.getLastCellNum(); j++) {

			Map<String, String> myMap = new HashMap<>();

			for(int i=1 ; i<rows + 1; i++) {
				Row r = CellUtil.getRow(i, sheet);
				String key = CellUtil.getCell(r, 0).getStringCellValue();
				String value = CellUtil.getCell(r, j).getStringCellValue();

				myMap.put(key, value);
				//System.out.println(myMap);
			}

			maplists.add(myMap);
		}

		System.out.println(maplists);
		return maplists;

	}
}
