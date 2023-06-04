package com.logoff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass {
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement radioButton;
	
	@FindBy(id="continue")
	private WebElement continueBtn;

	public WebElement getRadioButton() {
		return radioButton;
	}

	public void setRadioButton(WebElement radioButton) {
		this.radioButton = radioButton;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public void setContinueBtn(WebElement continueBtn) {
		this.continueBtn = continueBtn;
	}
	
}
