package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class PayrollInvoice {
	WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	@FindBy(xpath = "/html/body/header/div[3]/div/div/div[1]")
	WebElement invoicehead;
	public PayrollInvoice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public String invoicemsg() {
		String msg=invoicehead.getText();
		return msg;
	}
	
}
