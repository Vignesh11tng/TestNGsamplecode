package com.logoff;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDateRead {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\urlData.txt");
		List<String> readLines = FileUtils.readLines(f);
		String url = readLines.get(0);
		driver.manage().window().maximize();
		driver.get(url);
		WebElement table = driver.findElement(By.xpath("//div[@class='pointTable__widget widgetgap']"));
		List<WebElement> headingElements = table.findElements(By.tagName("th"));
		for (int i = 0; i < headingElements.size(); i++) {
			WebElement individualElement = headingElements.get(i);
			String headingTxt = individualElement.getText();
			System.out.print("\t" + headingTxt);
		}
		System.out.println();
		List<WebElement> rowElements = table.findElements(By.tagName("tr"));
		for (int i = 0; i < rowElements.size(); i++) {
			WebElement invidualRows = rowElements.get(i);
			List<WebElement> dataElements = invidualRows.findElements(By.tagName("td"));
			for (int j = 0; j < dataElements.size(); j++) {
				WebElement invidualData = dataElements.get(j);
				String invidivdualDataText = invidualData.getText();
				System.out.print("\t" + invidivdualDataText);
			}
			System.out.println();
		}
		
		File fnew = new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\sampledata.xlsx");
		FileInputStream fs = new FileInputStream(fnew);
		Workbook w = new XSSFWorkbook(fs);
		Sheet sheet = w.getSheet("sample");
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println();
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sheet.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if (cellType == 1) {
					String stringCellValue = cell.getStringCellValue();
					System.out.print("\t" + stringCellValue);
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
					String date = s.format(dateCellValue);
					System.out.print("\t" + date);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					System.out.print("\t" + l);
				}
			}
			System.out.println();
		}

	}
}

