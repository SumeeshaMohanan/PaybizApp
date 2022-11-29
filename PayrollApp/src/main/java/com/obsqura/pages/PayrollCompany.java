package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class PayrollCompany {
	WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	
	@FindBy(tagName="h1")
	WebElement heading;

	public PayrollCompany(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String companyHeading() {
		waitUtility.waitforanelement(heading, driver);
		String msg=heading.getText();
		return msg;
	}
}
