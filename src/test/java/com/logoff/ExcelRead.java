package com.logoff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\ExcelRead.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fs);
//		Sheet sheet = w.getSheet("sample");
		for (int k = 0; k < 3; k++) {
			System.out.println("======================To print sheet"+ (k+1) +"==========================");
			Sheet sheet1 = w.getSheetAt(k);
			for (int i = 0; i < 10; i++) {
				Row row = sheet1.getRow(i);
				for (int j = 0; j < 10; j++) {
					Cell cell = row.getCell(j);
					String stringCellValue = cell.getStringCellValue();
					System.out.print("\t" + stringCellValue);
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
	}

}
