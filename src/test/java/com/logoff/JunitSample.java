package com.logoff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class JunitSample extends BaseClass {

	@BeforeClass
	public static void m1() throws IOException {
		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\urlData.txt");
		List<String> readLines = FileUtils.readLines(f);
		String url = readLines.get(2);		
		browserLaunch(url);
	}
	
	@Before
	public void m2() {
		AdactinHomePage adact = new AdactinHomePage();
		WebElement txtUsername = adact.getTxtUsername();
		WebElement txtPassword = adact.getTxtPassword();
		WebElement btnLogin = adact.getBtnLogin();
		boolean displayed = txtUsername.isDisplayed();
		boolean displayed2 = txtPassword.isDisplayed();
		boolean loginabled = btnLogin.isEnabled();
		Assert.assertTrue(displayed);
		System.out.println("Username box Exists");
		Assert.assertTrue(displayed2);
		System.out.println("Password box Exists");
		Assert.assertEquals(true, loginabled);
		System.out.println("Login button enabled");
	}
	
	@Test
	public void m3() throws InterruptedException, IOException {
		
		File f = new File("C:\\Users\\HP\\Documents\\testjunit.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fs);	
		Sheet sheet = w.getSheet("sample");
		Row row = sheet.getRow(0);
		Cell cell0 = row.getCell(0);
		String Username = cell0.getStringCellValue();
		System.out.println(Username);
		Cell cell1 = row.getCell(1);
		String Password = cell1.getStringCellValue();
		Cell cell2 = row.getCell(2);
		String Location = cell2.getStringCellValue();
		Cell cell3 = row.getCell(3);
		String Hotels = cell3.getStringCellValue();
		Cell cell4 = row.getCell(4);
		String RoomType = cell4.getStringCellValue();
		Cell cell5 = row.getCell(5);
		String RoomNos = cell5.getStringCellValue();
		Cell cell6 = row.getCell(6);
		String DateIn = cell6.getStringCellValue();
		Cell cell7 = row.getCell(7);
		String DateOut = cell7.getStringCellValue();
		Cell cell8 = row.getCell(8);
		String AdultRoom = cell8.getStringCellValue();
		Cell cell9 = row.getCell(9);
		String ChildRoom = cell9.getStringCellValue();
		Cell cell10 = row.getCell(10);
		String FirstName = cell10.getStringCellValue();
		Cell cell11 = row.getCell(11);
		String LastName = cell10.getStringCellValue();
		Cell cell12 = row.getCell(12);
		String Address = cell10.getStringCellValue();
		Cell cell13 = row.getCell(13);
		String CCNUM = cell10.getStringCellValue();
		Cell cell14 = row.getCell(14);
		String CCTYPE = cell10.getStringCellValue();
		Cell cell15 = row.getCell(15);
		String CCEXPMONTH = cell10.getStringCellValue();
		Cell cell16 = row.getCell(16);
		String CCEXPYEAR = cell10.getStringCellValue();
		Cell cell17 = row.getCell(7);
		String CCCVV = cell10.getStringCellValue();

		
		AdactinHomePage adact = new AdactinHomePage();
		adact.getTxtUsername().sendKeys(Username);
		adact.getTxtPassword().sendKeys(Password);
		adact.getBtnLogin().click();
	
		SearchHotel search = new SearchHotel();
		WebElement selecttLocation = search.getSelecttLocation();
		WebElement selectHotels = search.getSelectHotels();
		WebElement selectRoomType = search.getSelectRoomType();
		WebElement selectRoomNos = search.getSelectRoomNos();
		WebElement datepickIn = search.getDatepickIn();
		WebElement datepickOut = search.getDatepickOut();
		WebElement adultRoom = search.getAdultRoom();
		WebElement childRoom = search.getChildRoom();
		WebElement submit = search.getSubmit();
		boolean selectedLocation = selecttLocation.isDisplayed();
		boolean selectedHotel = selectHotels.isDisplayed();
		boolean selectedRommType = selectRoomType.isDisplayed();
		boolean selectedRoomNos = selectRoomNos.isDisplayed();
		boolean displayedpickIn = datepickIn.isDisplayed();
		boolean displayedpickOut = datepickOut.isDisplayed();
		boolean selectedAdultRoom = adultRoom.isDisplayed();
		boolean selectedChildRoom = childRoom.isDisplayed();
		boolean submitEnabled = submit.isEnabled();
		Assert.assertTrue(selectedLocation);
		System.out.println("Location Selection box Exists");
		Assert.assertTrue(selectedHotel);
		System.out.println("Hotels Selection box Exists");
		Assert.assertTrue(selectedRommType);
		System.out.println("Room Type Selection box Exists");
		Assert.assertTrue(selectedRoomNos);	
		System.out.println("Room Nos Selection box Exists");
		Assert.assertTrue(displayedpickIn);
		System.out.println("DatepickIn box Exists");
		Assert.assertTrue(displayedpickOut);
		System.out.println("DatepickOut box Exists");
		Assert.assertTrue(selectedAdultRoom);
		System.out.println("AdultRoom Selection box Exists");
		Assert.assertTrue(selectedChildRoom);
		System.out.println("ChikdRoom Selection box Exists");
		Assert.assertEquals(true, submitEnabled);
		System.out.println("Submit button is enabled");

		search.getSelecttLocation();
		selectByMethod("selectByValue",selecttLocation,Location);
		search.getSelectHotels();
		selectByMethod("selectByValue",selectHotels,Hotels);
		search.getSelectRoomType();
		selectByMethod("selectByValue",selectRoomType,RoomType);
		search.getSelectRoomNos();
		selectByMethod("selectByValue",selectRoomNos,RoomNos);
		search.getDatepickIn().sendKeys(DateIn);
		search.getDatepickOut().sendKeys(DateOut);
		search.getAdultRoom();
		selectByMethod("selectByValue",adultRoom,AdultRoom);
		search.getChildRoom();
		selectByMethod("selectByValue",childRoom,ChildRoom);
		search.getSubmit();
		submit.click();
		
		
		Thread.sleep(2000);
		SelectHotel select = new SelectHotel();
		WebElement radioButton = select.getRadioButton();
		WebElement continueBtn = select.getContinueBtn();
		boolean displayedRadio = radioButton.isDisplayed();
		boolean displayedContBtn = continueBtn.isDisplayed();
		Assert.assertTrue(displayedRadio);
		System.out.println("Hotel selection completed");
		Assert.assertEquals(true, displayedContBtn);
		System.out.println("Continue Buttion enabled");
		radioButton.click();
		continueBtn.click();
		
		Thread.sleep(2000);
		BookHotel book = new BookHotel();
		WebElement firstName = book.getFirstName();
		WebElement lastName = book.getLastName();
		WebElement address = book.getAddress();
		WebElement ccNum = book.getCcNum();
		WebElement ccType = book.getCcType();
		WebElement ccExpMonth = book.getCcExpMonth();
		WebElement ccExpYear = book.getCcExpYear();
		WebElement ccCvv = book.getCcCvv();
		WebElement bookNow = book.getBookNow();
		boolean displayedFirstName = firstName.isDisplayed();
		boolean displayedLastName = lastName.isDisplayed();
		boolean displayedAddress = address.isDisplayed();
		boolean displayedCcNum = ccNum.isDisplayed();
		boolean displayedCcType = ccType.isDisplayed();
		boolean displayedCcExpMonth = ccExpMonth.isDisplayed();
		boolean displayedCcExpYear = ccExpYear.isDisplayed();
		boolean displayedCcCvv = ccCvv.isDisplayed();
		boolean enabled = bookNow.isEnabled();
		Assert.assertTrue(displayedFirstName);
		System.out.println("FirstName box Exists");
		Assert.assertTrue(displayedLastName);
		System.out.println("LastName box Exists");
		Assert.assertTrue(displayedAddress);
		System.out.println("Address box Exists");
		Assert.assertTrue(displayedCcNum);
		System.out.println("CcNum box Exists");
		Assert.assertTrue(displayedCcType);
		System.out.println("CcType box Exists");
		Assert.assertTrue(displayedCcExpMonth);
		System.out.println("Month Selection box Exists");
		Assert.assertTrue(displayedCcExpYear);
		System.out.println("Year Selection box Exists");
		Assert.assertTrue(displayedCcCvv);
		System.out.println("ccCvv box Exists");
		Assert.assertEquals(true, enabled);
		System.out.println("BookNow Buttoon enabled");
		enterText(firstName,FirstName);
		enterText(lastName,LastName);
		enterText(address,Address);
		enterText(ccNum,CCNUM);
		selectByMethod("selectByValue",ccType,CCTYPE);
		selectByMethod("selectByValue",ccExpMonth,CCEXPMONTH);
		selectByMethod("selectByValue",ccExpYear,CCEXPYEAR);
		enterText(ccCvv,CCCVV);
		click(bookNow);
		
	}
	
	@After
	public void m4() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("C:\\Users\\HP\\eclipse-workspace\\MavenNew\\src\\test\\resources\\screenshot.png"));
	}
	
	@AfterClass
	public static void m5() {
		close("close");
	}
}
