package com.logoff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement selecttLocation;
	
	@FindBy(id="hotels")
	private WebElement selectHotels;
	
	@FindBy(id="room_type")
	private WebElement selectRoomType;
	
	@FindBy(id="room_nos")
	private WebElement selectRoomNos;
	
	@FindBy(id="datepick_in")
	private WebElement DatepickIn;
	
	@FindBy(id="datepick_out")
	private WebElement DatepickOut;
	
	@FindBy(id="adult_room")
	private WebElement AdultRoom;
	
	@FindBy(id="child_room")
	private WebElement ChildRoom;
	
	@FindBy(id="Submit")
	private WebElement Submit;

	public WebElement getSelecttLocation() {
		return selecttLocation;
	}

	public void setSelecttLocation(WebElement selecttLocation) {
		this.selecttLocation = selecttLocation;
	}

	public WebElement getSelectHotels() {
		return selectHotels;
	}

	public void setSelectHotels(WebElement selectHotels) {
		this.selectHotels = selectHotels;
	}

	public WebElement getSelectRoomType() {
		return selectRoomType;
	}

	public void setSelectRoomType(WebElement selectRoomType) {
		this.selectRoomType = selectRoomType;
	}

	public WebElement getSelectRoomNos() {
		return selectRoomNos;
	}

	public void setSelectRoomNos(WebElement selectRoomNos) {
		this.selectRoomNos = selectRoomNos;
	}

	public WebElement getDatepickIn() {
		return DatepickIn;
	}

	public void setDatepickIn(WebElement datepickIn) {
		DatepickIn = datepickIn;
	}

	public WebElement getDatepickOut() {
		return DatepickOut;
	}

	public void setDatepickOut(WebElement datepickOut) {
		DatepickOut = datepickOut;
	}

	public WebElement getAdultRoom() {
		return AdultRoom;
	}

	public void setAdultRoom(WebElement adultRoom) {
		AdultRoom = adultRoom;
	}

	public WebElement getChildRoom() {
		return ChildRoom;
	}

	public void setChildRoom(WebElement childRoom) {
		ChildRoom = childRoom;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	public void setSubmit(WebElement submit) {
		Submit = submit;
	}
	
}
