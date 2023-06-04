package com.logoff;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartToExcel {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\urlData.txt");
		List<String> readLines = FileUtils.readLines(f);
		String url = readLines.get(1);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		File f1 = new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\FlipkartiPhone.xlsx");
		FileOutputStream fs = new FileOutputStream(f1);
		Workbook w = new XSSFWorkbook();
		Sheet createSheet = w.createSheet("iPhone14ProMax");
		WebElement cancelButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		cancelButton.click();
		WebElement txtbox = driver.findElement(By.xpath("//input[@type='text']"));
		txtbox.sendKeys("iPhone 14 pro max", Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> Elements = driver.findElements(By.xpath("(//div[contains(text(),'iPhone')])"));
		int rowNum = 0;
		for(int i=0;i<Elements.size();i++) {
			Row createRow = createSheet.createRow(i);
			WebElement invidualElement = Elements.get(i);
			String text = invidualElement.getText();
			Cell createCell = createRow.createCell(0);
			createCell.setCellValue(text);
			rowNum = Elements.size();
			System.out.println(text);
		}
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(10));
		Thread.sleep(5000);
		WebElement nextPageElement = driver.findElement(By.xpath("//span[text()='Next']"));
		nextPageElement.click();
		List<WebElement> nextPageElements = driver.findElements(By.xpath("//div[contains(text(),'iPhone')]"));
		for(int i=0;i<nextPageElements.size();i++) {
			try {
				Row createRow = createSheet.createRow(rowNum + i);
				WebElement invidualElement = nextPageElements.get(i);
				String text = invidualElement.getText();
				Cell createCell = createRow.createCell(0);
				createCell.setCellValue(text);
				System.out.println(text);
			}
			catch (Exception e) {
				
			}
		}
		w.write(fs);
	}

}
