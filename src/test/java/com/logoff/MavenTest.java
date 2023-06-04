package com.logoff;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\data1.txt");
		List<String> readLines = FileUtils.readLines(f);
		String url = readLines.get(0);
		System.out.println(url);
		System.out.println(readLines);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.xpath("//input[@autocomplete='name']"));
		WebElement orgName = driver.findElement(By.xpath("//input[@autocomplete='organization']"));
		WebElement streetAddress = driver.findElement(By.xpath("//input[@autocomplete='street-address']"));
		WebElement addresslvl2 = driver.findElement(By.xpath("//input[@autocomplete='address-level2']"));		
		WebElement addresslvl1 = driver.findElement(By.xpath("//input[@autocomplete='address-level1']"));		
		WebElement pincode = driver.findElement(By.xpath("//input[@autocomplete='postal-code']"));		
		WebElement countryCode = driver.findElement(By.xpath("//input[@autocomplete='country']"));		
		WebElement email = driver.findElement(By.xpath("//input[@autocomplete='email']"));		
		WebElement tel = driver.findElement(By.xpath("//input[@autocomplete='tel']"));		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));		
		
		
		String txtname = readLines.get(1);
		String txtOrgName = readLines.get(2);
		String txtAddress = readLines.get(3);
		String address2 = readLines.get(4);
		String address1 = readLines.get(5);
		String txtPincode = readLines.get(6);
		String txtCountryCode = readLines.get(7);
		String txtEmail = readLines.get(8);
		String txtTel = readLines.get(9);

		name.sendKeys(txtname);
		orgName.sendKeys(txtOrgName);
		streetAddress.sendKeys(txtAddress);
		addresslvl2.sendKeys(address2);
		addresslvl1.sendKeys(address1);
		pincode.sendKeys(txtPincode);
		countryCode.sendKeys(txtCountryCode);
		email.sendKeys(txtEmail);
		tel.sendKeys(txtTel);
		WebElement submit = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		submit.click();
	}

}
