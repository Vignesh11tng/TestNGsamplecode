package com.logoff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderNo extends BaseClass {
	public OrderNo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement orderNo;
	
	@FindBy(id="logout")
	private WebElement logOut;

	public WebElement getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(WebElement orderNo) {
		this.orderNo = orderNo;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public void setLogOut(WebElement logOut) {
		this.logOut = logOut;
	}
	
}
