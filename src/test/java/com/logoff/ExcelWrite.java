package com.logoff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\urlData.txt");
		List<String> readLines = FileUtils.readLines(f);
		String url = readLines.get(0);		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebElement table = driver.findElement(By.xpath("//div[@class='pointsDataTable']"));
		File f1 = new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\ExcelWrite.xlsx");
		FileOutputStream fo = new FileOutputStream(f1);
		Workbook w = new XSSFWorkbook();
		Sheet createSheet = w.createSheet("IPLPointsTable");
		List<WebElement> headingElement = table.findElements(By.tagName("th"));
		Row createRow = createSheet.createRow(0);
		for(int i=0; i<headingElement.size();i++) {
			WebElement invidualElement = headingElement.get(i);
			String text = invidualElement.getText();
			Cell createCell = createRow.createCell(i);
			createCell.setCellValue(text);
			System.out.print("\t"+ text);
		}
		System.out.println();
		
		List<WebElement> rowElements = table.findElements(By.tagName("tr"));
		
		for(int i=1;i<rowElements.size();i++) {
			WebElement invidualRowElements = rowElements.get(i);
			Row createRowData = createSheet.createRow(i);
			List<WebElement> dataElements = invidualRowElements.findElements(By.tagName("td"));
			
			for(int j=0; j<dataElements.size();j++) {
				WebElement invidualDataElement = dataElements.get(j);
				String text = invidualDataElement.getText();
				Cell createCell = createRowData.createCell(j);
				createCell.setCellValue(text);
				System.out.print("\t"+ text);
			}
		System.out.println();
		}
	w.write(fo);
	}

}
