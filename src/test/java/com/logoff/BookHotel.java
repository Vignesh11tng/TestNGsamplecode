package com.logoff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel extends BaseClass {
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="cc_num")
	private WebElement ccNum;
	
	@FindBy(id="cc_type")
	private WebElement ccType;
	
	@FindBy(id="cc_exp_month")
	private WebElement ccExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement ccExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement ccCvv;
	
	@FindBy(id="book_now")
	private WebElement bookNow;

	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(WebElement firstName) {
		this.firstName = firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(WebElement lastName) {
		this.lastName = lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public void setAddress(WebElement address) {
		this.address = address;
	}

	public WebElement getCcNum() {
		return ccNum;
	}

	public void setCcNum(WebElement ccNum) {
		this.ccNum = ccNum;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public void setCcType(WebElement ccType) {
		this.ccType = ccType;
	}

	public WebElement getCcExpMonth() {
		return ccExpMonth;
	}

	public void setCcExpMonth(WebElement ccExpMonth) {
		this.ccExpMonth = ccExpMonth;
	}

	public WebElement getCcExpYear() {
		return ccExpYear;
	}

	public void setCcExpYear(WebElement ccExpYear) {
		this.ccExpYear = ccExpYear;
	}

	public WebElement getCcCvv() {
		return ccCvv;
	}

	public void setCcCvv(WebElement ccCvv) {
		this.ccCvv = ccCvv;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public void setBookNow(WebElement bookNow) {
		this.bookNow = bookNow;
	}
	
}
