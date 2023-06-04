package com.logoff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExecutionClass extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		browserLaunch("http://adactinhotelapp.com/");
//		WebElement txtUsername = locateElement("id","username");
//		WebElement txtPassword = locateElement("id","password");
//		WebElement btnLogin = locateElement("id","login");
//		enterText(txtUsername,"Vigneshn660066");
//		enterText(txtPassword,"Vigneshn660066");
//		click(btnLogin);
		AdactinHomePage adact = new AdactinHomePage();
		WebElement txtUsername = adact.getTxtUsername();
		WebElement txtPassword = adact.getTxtPassword();
		enterText(txtUsername,"Vigneshn660066");
		enterText(txtPassword,"Vigneshn660066");
		WebElement btnLogin = adact.getBtnLogin();
		click(btnLogin);
		
		Thread.sleep(2000);
		SearchHotel search = new SearchHotel();
		WebElement selectLocation = search.getSelecttLocation();
		selectByMethod("selectByValue",selectLocation,"Sydney");
		WebElement selectHotels = search.getSelectHotels();
		selectByMethod("selectByValue",selectHotels,"Hotel Creek");
		WebElement selectRoomType = search.getSelectRoomType();
		selectByMethod("selectByValue",selectRoomType,"Standard");
		WebElement selectRoomNos = search.getSelectRoomNos();
		selectByMethod("selectByValue",selectRoomNos,"2");
		WebElement datepickIn = search.getDatepickIn();
		enterText(datepickIn,"09/05/2023");
		WebElement datepickOut = search.getDatepickOut();
		enterText(datepickOut,"10/05/2023");
		WebElement adultRoom = search.getAdultRoom();
		selectByMethod("selectByValue",adultRoom,"2");
		WebElement childRoom = search.getChildRoom();
		selectByMethod("selectByValue",childRoom,"2");
		WebElement submit = search.getSubmit();
		click(submit);
		
		Thread.sleep(2000);
		SelectHotel select = new SelectHotel();
		WebElement radioButton = select.getRadioButton();
		click(radioButton);
		WebElement continueBtn = select.getContinueBtn();
		click(continueBtn);
		
		Thread.sleep(2000);
		BookHotel book = new BookHotel();
		WebElement firstName = book.getFirstName();
		enterText(firstName,"Vignesh");
		WebElement lastName = book.getLastName();
		enterText(lastName,"Nithiyan");
		WebElement address = book.getAddress();
		enterText(address,"OMR, Perugudi, Chennai");
		WebElement ccNum = book.getCcNum();
		enterText(ccNum,"1234567890123456");
		WebElement ccType = book.getCcType();
		selectByMethod("selectByValue",ccType,"VISA");
		WebElement ccExpMonth = book.getCcExpMonth();
		selectByMethod("selectByValue",ccExpMonth,"2");
		WebElement ccExpYear = book.getCcExpYear();
		selectByMethod("selectByValue",ccExpYear,"2018");
		WebElement ccCvv = book.getCcCvv();
		enterText(ccCvv,"456");
		WebElement bookNow = book.getBookNow();
		click(bookNow);
		
		Thread.sleep(12000);
		OrderNo order = new OrderNo();
		WebElement orderNo = order.getOrderNo();
		String text = get(orderNo, "getText");
		System.out.println(text);
		WebElement logOut = order.getLogOut();
		click(logOut);
	}

}
